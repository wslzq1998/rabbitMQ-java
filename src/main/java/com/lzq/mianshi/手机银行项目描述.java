package com.lzq.mianshi;

public class 手机银行项目描述 {
    /*
    * 1、首页
    *   功能菜单显示，公告滚动，精选存款精选理财显示，快速转账显示
    * 2、交易明细
    *   卡列表，按照月份展示进账出账详情
    * 3、财富总览
    *   展示总资产，活期总额，定期总额，贷款总额，每张卡的余额信息，定期的详细信息，贷款的祥细信息
    * 4、转账
    *   最近收款人信息展示，收款人名册展示，收款人操作（增删改），
    *   转账展示，选择付款卡，卡列表查询，转账银行选择，开户地开户行查询
    *   转账记录，按月份展示转账记录
    *   转账设置，是否快捷匹配，剪切板内容识别，收款人名册，转账限额
    *   转账限额，查询卡列表，查询卡限额，卡通关闭转账权限，修改限额
    * 5、转账流程
    *   输入收款人信息，选择转账卡，点击转账，判断输入的信息是否存在错误，转账限额是否超限，对方卡是否异常等条件
    *   全部符合显示输入密码，输入密码错误多次进行锁定，正确则查询转账结果，显示最终结果
    * */
    /*
           面试官你好，我叫凌增奇，今年23岁，来自河南商丘，2020年毕业于山东科技大学计算机学院，在校期间成绩优异，多次获得班级奖学金，也
        参加过多次数学建模竞赛以及蓝桥杯竞赛，并取得不错的成绩。毕业之后进入上海安硕信息进行实习，主要从事一些数据处理以及银行信贷系统的
        代码改造工作；实习结束后我进入到了北京东方国信公司，任职java开发工程师，主要从事手机银行系统的研发工作。
           我参与的项目是营口沿海银行手机APP系统，使用的技术是springboot+mybatis+dubbo+zookeeper，数据库是Oracle，项目周期是
        2020年10月份到2021年5月份，项目前期我参与了系统的设计阶段，完成了项目的设计文档编写，之后参与项目的开发阶段，完成的模块
        包括首页，交易明细，财富总览以及转账四个模块。
        首页功能包括公告滚动，菜单展示，最近收款人展示，精选理财产品展示；
        交易明细模块包括银行卡列表查询以及按照月份展示进账出账详情；
        财富总览模块包括展示登陆用户的全部资产状况，显示每张卡的活期，定期，理财，贷款详情；
        转账模块包括收款人名册，转账记录，转账限额以及转账；
           以财富总览为例，从缓存中拿到登录用户的卡信息，然后调用了其他部门的三个接口，包括银行卡活期定期存款信息的接口，银行卡购买
        理财信息的接口，以及银行卡的贷款信息，之后进行汇总，汇总的过程中和数据库中的数据进行对比，不一致数据库就和接口返回数据同步，
        一致就返回数据。
           转账业务，输入的参数信息有付款卡的信息，收款卡的信息，转账的金额，这些信息前端首先会校验一次，通过后调用转账提交接口，后端会
        再校验一次，先判断输入的信息是否和数据库的信息一致，收付款卡是否异常，转账的金额是否超过剩余的金额，额度是否超限，校验通过之后
        会输入交易密码，此时会为了安全性再校验一次数据，根据选择的转账类型以及转账金额判断走大额汇路，还是小额汇路，根据汇路的不同，
        在转账时间限制上会有所不同，其中大额汇路只能在早上八点到晚上五点之间进行转账，节假日无法转账，小额汇路则没有限制条件，所以需要再
        根据汇路对当前日期时间进行判断，检验全部通过则扣除金额以及转账额度，最终再调用转账接口进行转账，但是如果接口返回错误，我们需要回滚
        操作，再把金额以及额度重新修改回去，延时转账，我们是写了一个定时任务，定时去查询结果，失败了同样回滚操作。

        项目难点：



    */

}
