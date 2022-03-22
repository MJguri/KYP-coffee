package team.kyp.kypcoffee.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OnedayClassApplierInfo {
    private int classNum;
    private Date classDate;
    private int classCapacity;
    private int classApplicantsNum;
    private int memberNum;
    private String memberName;
    private String memberAddress;
    private String memberTel;
    private String memberPhone;
    private String memberEmail;
}
