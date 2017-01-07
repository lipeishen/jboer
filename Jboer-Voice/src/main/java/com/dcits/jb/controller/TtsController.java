package com.dcits.jb.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.jb.util.splitUtil;



@Controller
@RequestMapping("/tts")
public class TtsController {
	
  @ResponseBody
  @RequestMapping("/getVoice")
  public void getResVoiceToClient(String  inputText){

	  /**工作过程如下：
	   * 开启购物按钮，则播报一些简介之类的东西，然后提示用户扫描二维码下载app 绑定
	   * 智能锅，并完善个人信息。这些操作完成之后，才能享受购物体验
	   * 
	   * 购物之前，启动购物键，完成锅和服务端通信状态验证，同时验证锅信息是否合法，一切都ok之后，提示用户：可以开始购物
	   * 然后用户开始购物，说出想要购买的商品。
	   * 
	   * 
	   * 1.机器调用上传接口，上传pcm 语音文件
	   * 2.上传成功的语音文件名以及所在的位置传给服务端
	   * 3. 服务端验证机器的信息，并将语音文件转化为文本
	   * 4. 对文本进行分词处理，提取关键字，
	   * 5. 根据关键字在数据库进行匹配，查询是否有用户需要的商品
	   * 6.如果没有，则提示该商品已售完，给出提示：结束购物或者继续购买其他商品；如果有，则播报价格，让用户说出需要的数量
	   * 7.用户说完购买数量之后，播报购买的商品名称、单价，数量、总价，然后让用户确认是否添加到购物车。
	   * 8.用户说出确认添加指令，机器提醒用户：“已经把商品添加到购物车并推送给app，请您及时去支付”，如果用户不想要刚才选择的商品，
	   * 则听到是否添加的指令后会选择（否或者不添加），服务端则不添加
	   * 9.如果取消订单，则手动的在app 上操作完成
	   * 10 ，用户打开手机app,去购物车结算，并完善个人信息，比如手机号，收货地址等信息，完成支付操作。
	   * 11. 手机完成之后，智能锅提示下单完成，货物大概在几天内送达，请做好收货准备。
	   *
	   */
	  
	  // 1.根据上传的文本，进行分词处理
	  List<String> wordList=splitUtil.cutString(inputText);
	  //2. 根据分词的结果，查询是否有需要购买的商品
	  
	  
	  
	  
  }
 
}
