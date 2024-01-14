package com.entity;

public class Liuyanban {
    private Integer id;
	private String cheng;
	private String xingbie;
	private String QQ;
	private String youxiang;
	private String shouji;
	private String neirong;
	private String huifuneirong;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getCheng() {
        return cheng;
    }
    public void setCheng(String cheng) {
        this.cheng = cheng == null ? null : cheng.trim();
    }
	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }
	public String getQQ() {
        return QQ;
    }
    public void setQQ(String QQ) {
        this.QQ = QQ == null ? null : QQ.trim();
    }
	public String getYouxiang() {
        return youxiang;
    }
    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang == null ? null : youxiang.trim();
    }
	public String getShouji() {
        return shouji;
    }
    public void setShouji(String shouji) {
        this.shouji = shouji == null ? null : shouji.trim();
    }
	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }
	public String getHuifuneirong() {
        return huifuneirong;
    }
    public void setHuifuneirong(String huifuneirong) {
        this.huifuneirong = huifuneirong == null ? null : huifuneirong.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
