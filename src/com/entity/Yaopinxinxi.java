package com.entity;

public class Yaopinxinxi {
    private Integer id;
	private String yaopinbianhao;
	private String yaopinmingcheng;
	private String chengfen;
	private String zhuzhizhengzhuang;
	private String tupian;
	private String shengchanyaochang;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYaopinbianhao() {
        return yaopinbianhao;
    }
    public void setYaopinbianhao(String yaopinbianhao) {
        this.yaopinbianhao = yaopinbianhao == null ? null : yaopinbianhao.trim();
    }
	public String getYaopinmingcheng() {
        return yaopinmingcheng;
    }
    public void setYaopinmingcheng(String yaopinmingcheng) {
        this.yaopinmingcheng = yaopinmingcheng == null ? null : yaopinmingcheng.trim();
    }
	public String getChengfen() {
        return chengfen;
    }
    public void setChengfen(String chengfen) {
        this.chengfen = chengfen == null ? null : chengfen.trim();
    }
	public String getZhuzhizhengzhuang() {
        return zhuzhizhengzhuang;
    }
    public void setZhuzhizhengzhuang(String zhuzhizhengzhuang) {
        this.zhuzhizhengzhuang = zhuzhizhengzhuang == null ? null : zhuzhizhengzhuang.trim();
    }
	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }
	public String getShengchanyaochang() {
        return shengchanyaochang;
    }
    public void setShengchanyaochang(String shengchanyaochang) {
        this.shengchanyaochang = shengchanyaochang == null ? null : shengchanyaochang.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
