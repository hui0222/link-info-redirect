package kr.co.lir.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseTime하위 필드도 컬럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) //BastTimeEntity 클래스에 auditing 기능을 포함시킴
public abstract class BaseTimeEntity {

    //Entitiy가 생성되어 저장 될때 시간 자동저장
    @CreatedDate
    private LocalDateTime createDate;

    //Entitiy가 수정되어 저장 될때 시간 자동저장
    @LastModifiedDate
    private LocalDateTime modifiyDate;
}
