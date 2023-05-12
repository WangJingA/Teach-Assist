package com.boot.teach.common.config;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.rmi.NoSuchObjectException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Component
public class MinioClientConfig {
    @Autowired
    MinioClient minioClient;
    @Value("${minio.bucketName}")
    private String bucketName;

    /**
     * 判断bucket是否存在
     * @param name
     * @return
     */
    public boolean existBucket(String name) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        if (!StringUtils.isEmpty(name)) {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
        }else{
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
        }
        return false;
    }

    /**
     * 创建bucket
     * @param bucketName
     * @return
     * @throws ServerException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidResponseException
     * @throws XmlParserException
     * @throws InternalException
     */
    public boolean createBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
       if (this.existBucket(bucketName)){
           return false;
       }
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
       return true;
    }

    /**
     * 删除bucket
     * @param bucketName
     * @return
     * @throws ServerException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidResponseException
     * @throws XmlParserException
     * @throws InternalException
     */
    public boolean delBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        if (!this.existBucket(bucketName)){
           return false;
        }
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        return true;
    }

    /**
     * 上传文件
     * @param file
     * @param bucketName
     * @return
     * @throws ServerException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidResponseException
     * @throws XmlParserException
     * @throws InternalException
     */
    public boolean uploadFile(MultipartFile file, String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        if (this.existBucket(bucketName)){
            String originalName = file.getOriginalFilename();
            String fileType = originalName.substring(originalName.lastIndexOf(".")+1);
            String fileName = originalName.substring(0,originalName.lastIndexOf("."))+ new Scanner(System.in).nextInt(5)+fileType;
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .stream(inputStream,inputStream.available(),-1)
                    .contentType(fileType)
                    .build());
            return true;
        }
        return false;
    }

    /**
     * 列表bucket-object
     * @param bucketName
     * @return
     * @throws ServerException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidResponseException
     * @throws XmlParserException
     * @throws InternalException
     */
    public List<Map<String,Object>> listBucketObject(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        if (!this.existBucket(bucketName)){
            throw  new NoSuchObjectException("bucket no exist");
        }
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        for (Result<Item> itemResult : results) {
            Item item = itemResult.get();
            map.put("filename",item.objectName());
            map.put("filesize",item.size());
            resultList.add(map);
        }
     return resultList;
    }

    /**
     * 下载
     * @param filename
     * @param bucketName
     * @param response
     * @throws ServerException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws InvalidResponseException
     * @throws XmlParserException
     * @throws InternalException
     */
    public void download(String filename,String bucketName,HttpServletResponse response) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        InputStream in = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(filename).build());
        HttpHeaders httpHeaders = new HttpHeaders();
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(in,outputStream);
    }
}
