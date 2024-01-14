package com.entity;

public class Hushixinxi {
    private Integer id;
	private String hushigonghao;
	private String mima;
	private String hushixingming;
	private String xingbie;
	private String dianhua;
	private String shenfenzheng;
	private String beizhu;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getHushigonghao() {
        return hushigonghao;
    }
    public void setHushigonghao(String hushigonghao) {
        this.hushigonghao = hushigonghao == null ? null : hushigonghao.trim();
    }
	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }
	public String getHushixingming() {
        return hushixingming;
    }
    public void setHushixingming(String hushixingming) {
        this.hushixingming = hushixingming == null ? null : hushixingming.trim();
    }
	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }
	public String getDianhua() {
        return dianhua;
    }
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua == null ? null : dianhua.trim();
    }
	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng == null ? null : shenfenzheng.trim();
    }
	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
