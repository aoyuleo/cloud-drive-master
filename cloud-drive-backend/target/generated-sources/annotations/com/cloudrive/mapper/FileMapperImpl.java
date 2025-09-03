package com.cloudrive.mapper;

import com.cloudrive.model.entity.FileInfo;
import com.cloudrive.model.entity.User;
import com.cloudrive.model.vo.FileListVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T16:38:40+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class FileMapperImpl implements FileMapper {

    @Override
    public FileListVO toFileListVO(FileInfo fileInfo) {
        if ( fileInfo == null ) {
            return null;
        }

        FileListVO fileListVO = new FileListVO();

        fileListVO.setId( fileInfo.getId() );
        fileListVO.setFilename( fileInfo.getFilename() );
        fileListVO.setOriginalFilename( fileInfo.getOriginalFilename() );
        fileListVO.setPath( fileInfo.getPath() );
        fileListVO.setFileSize( fileInfo.getFileSize() );
        fileListVO.setFileType( fileInfo.getFileType() );
        fileListVO.setParentId( fileInfo.getParentId() );
        fileListVO.setIsFolder( fileInfo.getIsFolder() );
        fileListVO.setCreatedAt( fileInfo.getCreatedAt() );
        fileListVO.setUpdatedAt( fileInfo.getUpdatedAt() );

        return fileListVO;
    }

    @Override
    public FileInfo toFileInfo(MultipartFile file, String filePath, User user, Long parentId) {
        if ( file == null && filePath == null && user == null && parentId == null ) {
            return null;
        }

        FileInfo fileInfo = new FileInfo();

        if ( file != null ) {
            fileInfo.setFilename( file.getOriginalFilename() );
            fileInfo.setOriginalFilename( file.getOriginalFilename() );
            fileInfo.setFileSize( file.getSize() );
            fileInfo.setFileType( file.getContentType() );
        }
        fileInfo.setPath( filePath );
        fileInfo.setUser( user );
        fileInfo.setParentId( parentId );
        fileInfo.setIsFolder( false );
        fileInfo.setIsDeleted( false );
        fileInfo.setCreatedAt( java.time.LocalDateTime.now() );
        fileInfo.setUpdatedAt( java.time.LocalDateTime.now() );
        fileInfo.setSha256Hash( com.cloudrive.common.util.FileHashUtil.calculateSHA256(file) );

        return fileInfo;
    }

    @Override
    public FileInfo toFileInfoForFastUpload(String filename, FileInfo existingFile, User user, Long parentId, String sha256Hash) {
        if ( filename == null && existingFile == null && user == null && parentId == null && sha256Hash == null ) {
            return null;
        }

        FileInfo fileInfo = new FileInfo();

        if ( filename != null ) {
            fileInfo.setFilename( filename );
            fileInfo.setOriginalFilename( filename );
        }
        if ( existingFile != null ) {
            fileInfo.setPath( existingFile.getPath() );
            fileInfo.setFileSize( existingFile.getFileSize() );
            fileInfo.setFileType( existingFile.getFileType() );
        }
        fileInfo.setUser( user );
        fileInfo.setParentId( parentId );
        fileInfo.setSha256Hash( sha256Hash );
        fileInfo.setIsFolder( false );
        fileInfo.setIsDeleted( false );
        fileInfo.setCreatedAt( java.time.LocalDateTime.now() );
        fileInfo.setUpdatedAt( java.time.LocalDateTime.now() );

        return fileInfo;
    }

    @Override
    public FileInfo toFileInfoFromPath(String filename, String filePath, long fileSize, User user, Long parentId, String sha256Hash) {
        if ( filename == null && filePath == null && user == null && parentId == null && sha256Hash == null ) {
            return null;
        }

        FileInfo fileInfo = new FileInfo();

        if ( filename != null ) {
            fileInfo.setFilename( filename );
            fileInfo.setOriginalFilename( filename );
        }
        fileInfo.setPath( filePath );
        fileInfo.setFileSize( fileSize );
        fileInfo.setUser( user );
        fileInfo.setParentId( parentId );
        fileInfo.setSha256Hash( sha256Hash );
        fileInfo.setFileType( com.cloudrive.common.util.FileTypeUtil.getContentTypeFromFileName(filename) );
        fileInfo.setIsFolder( false );
        fileInfo.setIsDeleted( false );
        fileInfo.setCreatedAt( java.time.LocalDateTime.now() );
        fileInfo.setUpdatedAt( java.time.LocalDateTime.now() );

        return fileInfo;
    }
}
