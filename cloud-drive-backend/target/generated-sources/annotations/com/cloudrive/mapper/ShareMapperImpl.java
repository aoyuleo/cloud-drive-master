package com.cloudrive.mapper;

import com.cloudrive.model.entity.FileInfo;
import com.cloudrive.model.entity.ShareRecord;
import com.cloudrive.model.entity.User;
import com.cloudrive.model.vo.ShareFileVO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T16:38:40+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ShareMapperImpl implements ShareMapper {

    @Override
    public ShareFileVO toShareFileVO(ShareRecord shareRecord) {
        if ( shareRecord == null ) {
            return null;
        }

        ShareFileVO shareFileVO = new ShareFileVO();

        shareFileVO.setShareCode( shareRecord.getShareCode() );
        shareFileVO.setExpireTime( shareRecord.getExpireTime() );
        shareFileVO.setFileId( shareRecordFileId( shareRecord ) );
        shareFileVO.setFilename( shareRecordFileFilename( shareRecord ) );
        shareFileVO.setFileSize( shareRecordFileFileSize( shareRecord ) );
        shareFileVO.setVisitCount( shareRecord.getVisitCount() );
        shareFileVO.setCreateTime( shareRecord.getCreateTime() );
        shareFileVO.setIsExpired( shareRecord.getIsExpired() );
        shareFileVO.setPassword( shareRecord.getPassword() );

        shareFileVO.setHasPassword( shareRecord.getPassword() != null && !shareRecord.getPassword().isEmpty() );

        return shareFileVO;
    }

    @Override
    public ShareRecord toShareRecord(FileInfo file, User user, String shareCode, String password, LocalDateTime expireTime) {
        if ( file == null && user == null && shareCode == null && password == null && expireTime == null ) {
            return null;
        }

        ShareRecord shareRecord = new ShareRecord();

        if ( file != null ) {
            shareRecord.setFile( file );
            shareRecord.setCreatedAt( file.getCreatedAt() );
            shareRecord.setUpdatedAt( file.getUpdatedAt() );
        }
        shareRecord.setUser( user );
        shareRecord.setShareCode( shareCode );
        shareRecord.setPassword( password );
        shareRecord.setExpireTime( expireTime );
        shareRecord.setIsExpired( false );
        shareRecord.setVisitCount( 0 );
        shareRecord.setCreateTime( java.time.LocalDateTime.now() );

        return shareRecord;
    }

    private Long shareRecordFileId(ShareRecord shareRecord) {
        if ( shareRecord == null ) {
            return null;
        }
        FileInfo file = shareRecord.getFile();
        if ( file == null ) {
            return null;
        }
        Long id = file.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String shareRecordFileFilename(ShareRecord shareRecord) {
        if ( shareRecord == null ) {
            return null;
        }
        FileInfo file = shareRecord.getFile();
        if ( file == null ) {
            return null;
        }
        String filename = file.getFilename();
        if ( filename == null ) {
            return null;
        }
        return filename;
    }

    private Long shareRecordFileFileSize(ShareRecord shareRecord) {
        if ( shareRecord == null ) {
            return null;
        }
        FileInfo file = shareRecord.getFile();
        if ( file == null ) {
            return null;
        }
        Long fileSize = file.getFileSize();
        if ( fileSize == null ) {
            return null;
        }
        return fileSize;
    }
}
