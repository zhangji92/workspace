package mode;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Biying {

    //今天
    private String today;
    //图片
    private int img;
    //每日单词
    private String dayword;
    //发音
    private String pronounce;
    //汉译
    private String translation;
    //每日一次
    private String mei_dayword;
    //加号图
    private int jiatu;


    //阅读图
    private int yuetu;
    //阅读题目
    private String title;
    //阅读作者
    private String zuoze;
    //内容
    private String text;
    //推荐阅读
    private String meiyu;

    //英语句子
    private String yingyujz;
    //翻译
    private String zhongwen;
    //每日一句
    private String meiryij;


    public Biying() {
    }

    public Biying(String yingyujz, String zhongwen, String meiryij) {
        this.yingyujz = yingyujz;
        this.zhongwen = zhongwen;
        this.meiryij = meiryij;
    }

    public Biying( int yuetu, String title, String zuoze, String text, String meiyu) {
        this.yuetu = yuetu;
        this.title = title;
        this.zuoze = zuoze;
        this.text = text;
        this.meiyu = meiyu;
    }


    public Biying(String today,int img, String dayword, String pronounce, String translation, String mei_dayword, int jiatu, int yuetu, String title, String zuoze, String text) {
        this.pronounce = pronounce;
        this.img = img;
        this.dayword = dayword;
        this.translation = translation;
        this.mei_dayword = mei_dayword;
        this.jiatu = jiatu;
        this.today= today;

    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDayword() {
        return dayword;
    }

    public void setDayword(String dayword) {
        this.dayword = dayword;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getMei_dayword() {
        return mei_dayword;
    }

    public void setMei_dayword(String mei_dayword) {
        this.mei_dayword = mei_dayword;
    }

    public int getJiatu() {
        return jiatu;
    }

    public void setJiatu(int jiatu) {
        this.jiatu = jiatu;
    }

    public int getYuetu() {
        return yuetu;
    }

    public void setYuetu(int yuetu) {
        this.yuetu = yuetu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZuoze() {
        return zuoze;
    }

    public void setZuoze(String zuoze) {
        this.zuoze = zuoze;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMeiyu() {
        return meiyu;
    }

    public void setMeiyu(String meiyu) {
        this.meiyu = meiyu;
    }

    public String getYingyujz() {
        return yingyujz;
    }

    public void setYingyujz(String yingyujz) {
        this.yingyujz = yingyujz;
    }

    public String getZhongwen() {
        return zhongwen;
    }

    public void setZhongwen(String zhongwen) {
        this.zhongwen = zhongwen;
    }

    public String getMeiryij() {
        return meiryij;
    }

    public void setMeiryij(String meiryij) {
        this.meiryij = meiryij;
    }
}
