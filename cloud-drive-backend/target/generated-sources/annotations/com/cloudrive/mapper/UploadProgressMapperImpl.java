package com.cloudrive.mapper;

import com.cloudrive.model.vo.UploadProgressVO;
import com.cloudrive.service.UploadProgressService;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T16:38:40+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class UploadProgressMapperImpl implements UploadProgressMapper {

    @Override
    public UploadProgressVO toUploadProgressVO(UploadProgressService.UploadTask task) {
        if ( task == null ) {
            return null;
        }

        UploadProgressVO uploadProgressVO = new UploadProgressVO();

        uploadProgressVO.setTaskId( task.getId() );
        uploadProgressVO.setFilename( task.getFilename() );
        uploadProgressVO.setTotalSize( task.getTotalSize() );
        uploadProgressVO.setBytesTransferred( task.getBytesTransferred() );
        uploadProgressVO.setProgress( task.getProgress() );
        uploadProgressVO.setCompleted( task.isCompleted() );
        uploadProgressVO.setSuccess( task.isSuccess() );
        uploadProgressVO.setMessage( task.getMessage() );

        return uploadProgressVO;
    }
}
