package online.shenjian.tio.im.server.vo;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/23
 */
public class IdiomVo {

    private String idiom;
    private String first; // 首字母
    private String pinyin;
    private String paraphrase;

    public IdiomVo() {}

    public IdiomVo(String idiom, String first, String pinyin, String paraphrase) {
        this.idiom = idiom;
        this.first = first;
        this.pinyin = pinyin;
        this.paraphrase = paraphrase;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }
}
