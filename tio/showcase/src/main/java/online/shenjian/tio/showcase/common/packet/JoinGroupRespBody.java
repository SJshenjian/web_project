package online.shenjian.tio.showcase.common.packet;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/8/30
 */
public class JoinGroupRespBody extends BaseBody {

    public static interface Code {
        Integer SUCCESS = 1;
        Integer FAIL = -1;
    }

    private Integer code;
    private String note;
    private String group;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
