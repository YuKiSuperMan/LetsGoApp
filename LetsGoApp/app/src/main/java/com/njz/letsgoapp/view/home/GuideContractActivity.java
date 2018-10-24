package com.njz.letsgoapp.view.home;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.base.BaseActivity;

/**
 * Created by LGQ
 * Time: 2018/8/16
 * Function:
 */

public class GuideContractActivity extends BaseActivity {

    public int type;
    private TextView tv_content;

    @Override
    public void getIntentData() {
        super.getIntentData();
        type = intent.getIntExtra("CONTRACT_TYPE", 0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide_contract;
    }

    @Override
    public void initView() {
        showLeftAndTitle(type == 0 ? "向导服务合同" : "用户协议");

        tv_content = $(R.id.tv_content);
        tv_content.setText(type == 0 ? SREVICE_CONTRACT : USER_PROTOCOL);
//        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());
        //textview自带滑动，xml添加android:scrollbars="vertical"

    }

    @Override
    public void initData() {

    }


    public final String USER_PROTOCOL = "那就走用户服务协议\n" +
            "\n" +
            "《那就走用户服务协议》（以下简称“本协议”）作为那就走平台（以下简称“本平台”）提供服务的依据，确定用户在何种条件、以何种方式使用本平台及本平台的服务（具体载体包括但不限于网页、APP应用程序、微信小程序、微信公众号平台等）。在使用本平台及相关服务前，您应当注册成为本平台用户。进行用户注册时，请您认真阅读本协议，一旦完成注册即表示您已经知悉并了解本协议，接受本协议的条款约束，本协议当即具有合同效力。如您对本协议的任何条款表示异议，您可以选择不使用本平台。 \n" +
            "本协议包括基于本协议制定的各项规则，所有规则为本协议不可分割的一部分，与本协议具有同等效力。本平台有权随时变更本协议并在本页面发布。当您继续使用本平台及相关服务，则视为您完全接受协议的变更。那就走平台的所有权、运营权、解释权归湖南那就走网络科技有限公司所有。 \n" +
            "\n" +
            "第一条 服务描述及定义 \n" +
            "本平台是连接游客与导游的综合信息服务平台。 “本平台”“那就走”：指那就走平台，载体包括但不限于网页（http://www.njzou.com）、App应用程序、微信小程序、微信公众号等。 “用户”：指具有完全民事行为能力的那就走平台使用者。用户身份包括 “游客”“导游”等。 “游客”是指有旅游辅助服务需求，具有完全民事行为能力的成年人。“导游”指具有导游资格证并经过平台实名认证后的导游，可以利用本平台为游客提供向导服务等一系列的服务。“帐号”：指用户为使用本平台及相关服务而登记注册的用户身份识别信息。用户只有注册帐号才能使用本平台的服务。\n" +
            "\n" +
            "第二条 用户的权利和义务 \n" +
            "1、用户有权根据本协议及本平台发布的相关规则，可利用本平台查看及发布旅游服务信息； \n" +
            "2、用户在使用本平台服务的过程中，须对自身的行为负责，对由此产生的任何后果承担全部责任； \n" +
            "3、用户有义务确保在本平台上发布的服务信息真实、准确，无误导性； \n" +
            "4、用户在本平台上发布服务信息，不得违反国家法律、法规、行政规章的规定、不得侵犯他人知识产权或其他合法权益的信息、不得违背社会公共利益或公共道德、不得违反本平台的相关规定； \n" +
            "5、用户在本平台交易中应当遵守诚实信用原则，不得以干预或操纵发布交易信息等不正当竞争方式扰乱网上交易秩序，不得从事与网上交易无关的不当行为； \n" +
            "6、用户承诺自己在使用本平台实施的所有行为遵守法律、法规、行政规章和本平台的相关规定以及各种社会公共利益或公共道德。如有违反导致任何法律后果的发生，用户将以自己的名义独立承担相应的法律责任； \n" +
            "7、用户如需要平台提供代收代付款项服务，必须提出申请经平台审核同意后进行。由上述代收代付行为所可能产生的税费由用户本人承担。 \n" +
            "8、未经本平台书面允许，用户不得将本平台的任何资料以及其他用户在平台中所展示的任何信息作商业性利用（包括但不限于以复制、修改、翻译等形式制作衍生作品、分发或公开展示）； \n" +
            "9、用户不得使用以下方式登录平台或破坏平台所提供的服务： \n" +
            "    A、以任何机器人软件、蜘蛛软件、爬虫软件、刷屏软件或其它自动方式访问或登录本平台； \n" +
            "    B、通过任何方式对本公司内部结构造成或可能造成不合理或不合比例的重大负荷的行为； \n" +
            "    C、通过任何方式干扰或试图干扰平台的正常工作或平台上进行的任何活动。 \n" +
            "10、用户同意接收来自本平台的信息，包括但不限于活动信息、服务信息等。 \n" +
            "\n" +
            "第三条 本平台的权利和义务\n" +
            "1、本平台仅为用户提供一个信息交流平台，本平台认为有必要的情况下，有权对用户发布的信息做出审查、指导，并有权要求用户做出解释、更正或删除。 \n" +
            "2、本平台有权收集和使用用户在使用本平台服务的过程中产生的数据、使用痕迹等信息，包括但不限于报名导游数量、导游的带团经验、导游从业信息、用户活跃度、用户人均在线时长等。为服务用户的目的，那就走可能通过使用用户的个人信息，向用户提供服务，包括但不限于向用户推荐导游、发出活动和服务信息等。用户在享用本平台服务的同时，同意接受本平台服务提供的各类信息服务。 \n" +
            "3、本平台有义务在现有技术水平的基础上努力确保整个网上展示、交流平台的正常运行，尽力避免服务中断或将中断时间限制在最短时间内，保证用户网上交流活动的顺利进行； \n" +
            "4、通过本平台发布的任何信息，及通过本平台服务传递的任何观点不代表本平台立场，本平台亦不对其完整性、真实性、准确性或可靠性负责。用户对于本平台发布的任何内容，应自行做出判断。在任何情况下，对于任何信息，包括但不仅限于其发生的任何错误或遗漏；或是由于使用通过本平台发布、传达、其他方式所释出的或在别处传播的信息，而造成的任何损失或伤害，应由相关行为主体承担全部责任。 \n" +
            "\n" +
            "第四条 服务内容\n" +
            "1、用户可以在平台中发布有偿旅游服务的信息，发布有偿服务信息者即为“导游”。导游可以在本平台中展示其服务信息。 \n" +
            "2、如游客需要导游提供服务的，所引起的法律风险由双方自行承担，本平台不为该等行为提供监督或承担任何责任。 \n" +
            "\n" +
            "第五条 发布信息特别规则\n" +
            "1、用户须承诺，其发布的信息真实有效，合法安全。导游须确保其提供的服务优质、高效。如因导游的过失引起纠纷的由导游承担相应的责任。 \n" +
            "2、因导游的过失产生争议的，由导游与游客先行协商，协商仍无法解决时，可提请法律诉讼。 \n" +
            "\n" +
            "第六条 服务的中断和终止\n" +
            "1、如发生下列任何一种情形，本平台有权随时中断或终止向用户提供本协议项下的平台服务而无需对用户或任何第三方承担任何责任： \n" +
            "A、用户违反法律法规国家政策； \n" +
            "B、用户违反本协议及相关规则规定； \n" +
            "C、本协议终止或更新时，用户未确认新的协议的； \n" +
            "D、其它本平台认为需终止服务的情况。 \n" +
            "2、若平台服务中断或终止，本平台将尽可能及时通过平台公告、系统通知、短信提醒或其他合理方式通知受到影响的用户。 \n" +
            "\n" +
            "第七条 本平台的责任范围\n" +
            "当用户接受该协议时，用户应当明确了解并同意： \n" +
            "1、本平台不能随时预见到任何技术上的问题或其他困难。该等困难可能会导致数据损失或其他服务中断。本平台是在现有技术基础上提供的服务。本平台不保证以下事项： \n" +
            "A、本平台将符合所有用户的要求； \n" +
            "B、本平台不受干扰、能够及时提供、安全可靠或免于出错； \n" +
            "C、本服务使用权的取得结果是正确或可靠的。 \n" +
            "2、是否经由本平台下载或取得任何资料，由用户自行考虑、衡量并且自负风险，因下载任何资料而导致用户电脑系统的任何损坏或资料流失，用户应负完全责任； \n" +
            "3、用户经由本平台取得的建议和资讯，无论其形式或表现，绝不构成本协议未明示规定的任何保证； \n" +
            "4、基于以下原因而造成的利润、商誉、使用、资料损失或其它无形损失，本平台不承担任何直接、间接、附带、特别、衍生性或惩罚性赔偿（即使本平台已被告知前款赔偿的可能性）： \n" +
            "A、本平台的使用或无法使用； \n" +
            "B、用户的传输或资料遭到未获授权的存取或变更； \n" +
            "C、本平台中任何第三方之声明或行为； \n" +
            "D、本平台在服务交易中为用户提供交易机会，推荐交易方； \n" +
            "E、本平台其它相关事宜。 \n" +
            "5、外部链接指向的网页内容非本平台实际控制的，因此本平台无法保证为向用户提供便利而设置的外部链接的准确性和完整性。外部链接指向的网页均由各经营者自行负责，不属于本平台控制及负责范围之内。对于存在或来源于此类平台或资源的任何内容、广告、物品或其它资料，本平台亦不予保证或负责。因使用或依赖任何此类平台或资源发布的或经由此类平台或资源获得的任何内容、物品或服务所产生的任何损害或损失，本平台不负任何直接或间接的责任。 \n" +
            "\n" +
            "第八条 版权声明\n" +
            "本平台旗下网站、移动端应用和服务中的所有知识产权（不论是否已登记注册）、网站中的信息内容、数据库、网站和移动端的设计、文字和图表、软件、照片、录像、音乐、声音及其前述组合，以及所有软件编译、源代码和软件（包括小应用程序和脚本）均为本平台的财产，并受相应的法律保护。未经本平台或权利人明示授权，用户保证不修改、出租、出借、出售、散布本平台及本平台所使用的上述任何资料和资源，或根据上述资料和资源制作成任何种类产品； \n" +
            "\n" +
            "第九条 隐私保护\n" +
            "本平台保证不会将用户的个人信息及用户在使用平台服务时存储在本平台的非公开内容用于任何非法的用途，且保证将用户的个人信息进行商业上的利用时应事先获得用户的同意，但下列情况除外： \n" +
            "1、事先获得用户的明确授权； \n" +
            "2、为维护社会公共利益； \n" +
            "3、学校、科研机构等基于公共利益为学术研究或统计的目的，经自然人用户书面同意，且公开方式不足以识别特定自然人； \n" +
            "4、用户自行在网络上公开的信息或其他已合法公开的个人信息； \n" +
            "5、以合法渠道获取的个人信息； \n" +
            "6、用户侵害本平台合法权益，为维护前述合法权益且在必要范围内； \n" +
            "7、根据相关政府主管部门的要求； \n" +
            "8、根据相关法律法规或政策的要求； \n" +
            "9、其他必要情况。 \n" +
            "\n" +
            "第十条 不可抗力\n" +
            "本合同所称之不可抗力意指不能预见、不能避免并不能克服的客观情况，包括但不限于战争、台风、水灾、火灾、雷击或地震、罢工、暴动、法定疾病、黑客攻击、网络病毒、电信部门技术管制、政府行为或任何其它自然或人为造成的灾难等客观情况。 \n" +
            "1、因不可抗力或者其他意外事件，使得本协议的履行不可能、不必要或者无意义的，双方均不承担责任； \n" +
            "2、对于因不可抗力或本平台不能控制的原因造成的平台服务中断或其它缺陷，本平台不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。 \n" +
            "\n" +
            "第十一条 保密\n" +
            "双方保证在对讨论、签订、执行本协议中所获悉的属于对方的且无法自公开渠道获得的文件及资料（包括但不限于商业秘密、公司计划、运营活动、财务信息、技术信息、经营信息及其他商业秘密）予以保密。未经该资料和文件的原提供方同意，另一方不得向第三方泄露该商业秘密的全部或者部分内容。但法律、法规、行政规章另有规定或者双方另有约定的除外。 \n" +
            "\n" +
            "第十二条 服务纠纷解决方式\n" +
            "1、本协议及其规则的有效性、订立、履行、解释和与本协议及其规则效力有关的所有事宜，将受中华人民共和国法律约束，任何争议均适用中华人民共和国法律； \n" +
            "2、如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协商不成时，任何一方均可提请网络仲裁，并根据网络仲裁规则进行网络仲裁活动。 \n" +
            "3、游客与导游之间的线下活动，包括沟通、面试、雇佣、劳务派遣等，不受本网站的约束。双方发生纠纷的，依据法律法规、双方合同处理，本平台不负责处理。本平台提供用户反馈渠道，包括网站特定模块或功能，用户可按特定方式表达、反映用户间的纠纷，但本网站不保证做出反馈或协助处理。 \n" +
            "\n" +
            "第十三条 免责声明\n" +
            "在使用“那就走”前，请务必仔细阅读并透彻理解本声明。您可以主动取消或停止使用“那就走”提供的服务，同时可注销您在“那就走”平台注册过的账号。如继续使用“那就走”服务，则视为您对本声明的全部内容的认可。 \n" +
            "1、发布服务信息的导游应该保证其发布的需求是真实、安全、规范、合法的，需求中所包含的内容在发生过程中不得有违反当地的法律条款的内容（“那就走”平台对于服务内容的真实性、安全性、规范性、合法性不做实质审查）。\n" +
            "2、“那就走”作为提供旅游信息的服务提供商，将导游的旅游服务信息汇集于互联网平台，供用户搜索、展示、预定和购买，但自身不提供、不出售旅游产品。 \n" +
            "3、导游发布的旅程应是安全、规范、合法的基础上，游客需要为自己在行程发生过程中的个人人身安全和财产安全负责，旅程中出现的人身伤害或财产损失与“那就走”平台无关。 \n" +
            "4、导游应在出行前与游客确定好服务价格，如在旅程过程中，导游与游客就相关费用产生的任何纠纷或争议与“那就走”平台无关。 \n" +
            "5、导游在旅程中涉及到的旅游服务必须合法，不得使用不合法的旅游服务供应商，如导游违反前述要求给游客带来任何损害或损失，应自行承担相关责任，与“那就走”平台无关。 \n" +
            "6、因用户提供注册信息或其他信息而对自己或其他人造成的任何损害，应由提供信息的用户承担相应责任，“那就走”平台将不承担任何责任。 \n" +
            "7、对于部分服务，导游取得收入，应当自行依据对其具有管辖权的税收法律申报并缴纳相应税款，“那就走”平台不具有任何代扣代缴或代为申报的义务。 \n" +
            "8、请用户及时保存或备份你的交易信息、文字、图片等其他信息，你完全理解并同意，由于“那就走”储存设备有限、设备故障、设备更新或设备受到攻击等设备原因或人为原因，用户使用网路服务储存的信息或数据等全部或部分发生删除、毁损、灭失或无法恢复的风险，均由用户自行承担，“那就走”不承担任何责任。 \n" +
            "9、导游和“那就走”不是雇佣关系，导游只是平台的用户，“那就走”对导游的服务不承担任何承诺及担保。 \n" +
            "\n" +
            "第十四条 协议的更新及修改\n" +
            "本平台保留随时修正、更新本协议的权利。一旦发生相关修订或更新，本平台会将修订和更新的内容及时在本页面发布，用户如认为变更无法接受，应该停止使用本平台相关服务。如果继续使用本平台相关服务的，则视为用户接受变更条款并愿意受其约束。 \n" +
            "\n" +
            "第十五条 违约责任\n" +
            "任何一方违反本协议约定的行为均构成违约行为，均应承担相应的责任。 \n" +
            "用户未按照本协议约定使用本平台的服务，本平台有权对用户停止服务或对用户发布的信息进行删除。 \n" +
            "对于用户的任何违反本协议规定的行为，本平台有权采取相应处理措施，方式包括但不限于记录不良行为、调整用户信用等级、黑白名单限制、封禁用户帐号等，形式包括系统后台记录或网站公示公开。该等处理措施将影响用户使用本平台的服务，涉及违法、犯罪的，本网站将移交司法机关处理。 \n" +
            "遭受不可抗力事件的一方可暂行中止履行本合同项下的义务直至不可抗力事件的影响消除为止，并且无需为此而承担违约责任；但应尽最大努力克服该事件，减轻其负面影响。 \n" +
            "\n" +
            "第十六条 其他\n" +
            "“那就走平台”拥有对本协议的最终解释权。 \n" +
            "用户与本平台的任何纠纷，可以通过协商的途径解决。协商不成的，任何一方可向本平台登记住所地的人民法院提起诉讼。 \n" +
            "本协议的订立、生效、解释、执行、管辖、争议的解决均适用中华人民共和国法律。 \n";


    public final String SREVICE_CONTRACT = "向导自由执业三方合同\n" +
            "\n" +
            "服务接受者和向导阅读本合同条款未提出异议的，平台视为服务接受者和向导已全部接受，且三方已于网上签订电子合同，该电子合同具有和书面合同同等的法律效力，服务接受者点击同意接受本合同条款内容且产品订单经向导最终确认后的视为合同生效\n" +
            "\n" +
            "根据《中华人民共和国旅游法》、《中华人民共和国合同法》及有关法律法规的规定，三方在平等、自愿、协商一致的基础上，就下列委托事项达成如下协议：\n" +
            "\n" +
            "第一章   术语与定义\n" +
            "\n" +
            "第一条   术语与定义\n" +
            "\n" +
            "1.1.    自由执业向导，指熟悉旅游目的地，且具备充分专业知识和经验，能够为服务接受者提供向导服务并在当地具有经常住所地的合法居民。\n" +
            "\n" +
            "1.2.    向导服务，指可分别提供与旅游目的地相关的景点讲解，车辆租赁，口译笔译，行程规划，餐厅预约，旅游咨询，及接送机等一项或多项特色化服务。\n" +
            "\n" +
            "1.3.    平台，指通过那就走旅游平台向自由执业向导提供展示其服务项目的内容，供服务接受 者选择，直接通过平台自行与服务接受者达成交易，提供向导服务。\n" +
            "\n" +
            "1.4.    服务接受者，指通过平台选择并购买自由执业向导提供的服务，并支付相应服务费的自然人、法人及其他组织。\n" +
            "\n" +
            "1.5.    第三方支付，是指独立于平台、向导、服务接受者的第三方支付机构为向导自由执业参与各方的交易提供的支付方式。\n" +
            "\n" +
            " \n" +
            "\n" +
            "第二章  承诺与声明\n" +
            "\n" +
            " \n" +
            "\n" +
            "第二条  平台、向导、服务接受者自愿做出如下声明和承诺。\n" +
            "\n" +
            "第三条  以下声明和承诺亦是各方参与本合同相关交易、服务的前提和条件。以下承诺和声明如有不实、虚假的，做出不实、虚假承诺的一方，应向受此不实、虚假承诺和声明误导而遭受损失的另外两方承担相应责任，该责任包括但不限于给另外两方造成的经济损失、人身损害、声誉损失等。\n" +
            "\n" +
            "对各方做出的承诺和声明，其他两方应予以确认并认同，如不接受该声明和承诺的，应通过补充协议对相关声明和承诺做出保留意见的说明，否则将视同对各方承诺和声明的接受和认可。\n" +
            "\n" +
            "第四条  平台做出如下承诺和声明：\n" +
            "\n" +
            "4.1 平台通过向导平台后台管理系统为向导提供平台基础服务，包括但不限于信息编辑、用户点评回复等，现有以及后续可能提供的增值服务、推广技术服务。\n" +
            "\n" +
            "4.2平台致力于不断提高向导服务的产品与技术质量、优质的用户体验以及系统的安全稳定。\n" +
            "\n" +
            "4.3平台承诺处理向导自由执业过程中产生的纠纷和投诉，并建立先行赔付公开承诺制度。\n" +
            "\n" +
            "本合同所涉及的平台“先行赔付公开承诺制度”指，服务接受者向平台投诉反馈并提供有关材料后，平台有权对该类争议自行判断，向导认可平台对于该类事宜的相关处理决定。如经平台核实确认向导在自由执业过程中确实存在故意、重大过失等责任的，平台有权未经向导同意，先行将向服务接受者退还部分或全部向导服务费，无论在何种情况下，平台向服务接受者承担的赔偿金额均不超过都不得超过服务接受者通过平台支付的向导服务费。\n" +
            "\n" +
            "第五条  向导做出如下承诺和声明：\n" +
            "\n" +
            "5.1 向导承诺其在注册环节向平台提交的证明材料合法、真实、准确详尽，并应按照平台要求提供相应的资质文件证明，包括但不限于，身份证件，护照，驾照，国外居留证明，车辆保险，语言证书，学习及工作经验等，否则向导承诺独立承担因此导致的相应责任及后果，使平台免责。\n" +
            "\n" +
            "5.2向导承诺其提供的向导服务符合当地的法律法规，不存在任何违法事宜。\n" +
            "\n" +
            "5.3向导承诺其提供的向导服务符合中国法律法规，不以个人名义直接或间接经营包价旅游产品。\n" +
            "\n" +
            "5.4向导承诺其通过平台发布、编辑、更新的向导信息真实准确，包括但不限于文字、图片等，并且不侵犯任何人的合法权益。\n" +
            "\n" +
            "5.5向导承诺在其接受除平台基础服务之外的增值服务、推广技术服务时，严格遵守相关服务协议的相关约定。\n" +
            "\n" +
            "5.6向导同意在使用平台向导服务的同时接受平台向其登记的电子邮件、手机、通信地址发送商业信息。\n" +
            "\n" +
            "5.7向导承诺维护点评内容的客观、真实性，不得进行违反诚信的任何行为，包括但不限于：炒作向导，参与或组织撰写及发布虚假点评、以利益诱惑、威胁等手段要求第三人发布虚假点评内容、进行其他其它影响点评真实性、客观性、干扰扰乱网站正常秩序的违规行为等，以上炒作向导、虚假点评行为不限于对向导自己的炒作，也包括炒作其他向导、对其他向导进行虚假点评等不正当竞争行为。\n" +
            "\n" +
            "5.8向导承诺向服务接受者提供优质服务，遵守诚信、公平交易的基本原则，在提供服务过程中工作积极，态度端正，决不从事或参与一切损害服务接受者合法权益的事宜。\n" +
            "\n" +
            "5.9向导承诺接受平台对自己向平台发送、提交的与向导服务相关的个人信息、执业经历介绍、宣传图片、语音、视频等相关资料的管理，包括但不限于复制、修改、编辑等。\n" +
            "\n" +
            "5.10向导承诺遵守平台针对向导制定的流程管理、培训课程、投诉处理等规章制度，不损害平台商誉、品牌形象。\n" +
            "\n" +
            "第六条 服务接受者做出如下承诺和声明：\n" +
            "\n" +
            "6.1服务接受者承诺对向导自由执业的相关事宜有充分的认知和了解，对接受服务过程中可能产生的问题和风险有完全的承受能力。\n" +
            "\n" +
            "6.2服务接受者承诺如为自然人的，应具有完全民事行为能力，可签署或确认本合同内容。\n" +
            "\n" +
            "6.3服务接受者承诺在接受向导服务后，根据向导服务的态度、质量客观评价向导的服务。\n" +
            "\n" +
            "6.4服务接受者充分知晓并认可，向导不具备导游资质，且其提供的仅是单项特色化服务，不属于包价旅游产品。\n" +
            "\n" +
            "6.5遵守诚信、公平交易的基本原则，认真履行本合同及与向导、平台就向导服务业务另行签署的其他合同规定的责任和义务。\n" +
            "\n" +
            "第三章  合同的订立\n" +
            "\n" +
            "第七条 平台、向导与服务接受者三方自愿订立本合同。合同订立后，三方应遵守本合同中的各项条款及相关法律、法规及相关规定。\n" +
            "\n" +
            "第八条 本合同对平台与向导、平台与服务接受者、向导与服务接受者之间的交易或服务未约定的事宜，当事人可另行约定或签署相应的合同。\n" +
            "\n" +
            "第九条 服务接受者登录平台网站，依据本合同文本在平台选择向导为自己提供自由执业服务并点击确认或同意本合同内容的，即视为认同本合同内容，享有本合同的权利并负有合同的义务，承担相应的合同责任。\n" +
            "\n" +
            "第十条 向导已阅读并理解本合同内容，服务接受者提交订单后，向导接到平台推送消息后，通过互联网界面，点击确认本合同内容，即视为认同本合同内容，享有本合同的权益并负有本合同的义务，承担相应的合同责任。\n" +
            "\n" +
            "第十一条 服务接受者的代表或代理人应当保证，自己对本合同的确认或签章，能够代表所有服务接受者对合同各项条款的认可。\n" +
            "\n" +
            "第十二条 服务接受者的代表或代理人签署、确认本合同后，须将本合同内容告知其他服务接受者，所有服务接受者均应当按照合同约定行使权利、履行义务。\n" +
            "\n" +
            "第十三条 服务接受者和向导，可依据平台设计的交易程序和规则，在平台上进行沟通协商，建议向导服务合同关系，由双方依约履行。\n" +
            "\n" +
            "第十四条 向导或平台对外做出的广告和宣传信息应当遵循诚实信用原则，其内容符合《中华人民共和国合同法》要约规定的，视为本合同的组成部分，对向导或平台具有约束力。\n" +
            "\n" +
            "第四章  合同变更\n" +
            "\n" +
            "第十五条 平台可根据相关法律、法规或相关政策的变化、调整，或根据互联网技术的发展、或为了改进技术、优化服务等原因，变更、调整合同条款。平台变更、调整合同条款后，应及时通知在本平台注册的向导。向导和服务接受者在使用平台服务时，应对最新的条款进行仔细阅读和重新确认，当发生有关争议时，应以最新的条款为准。条款的变更影响到向导和服务接受者实质的权利义务关系时，向导和服务接受者在未得到平台通知或同意该等调整和修改时，仍以此前签署和确认的合同为依据处理有关争议。\n" +
            "\n" +
            "第十六条 平台与向导、平台与服务接受者、向导与服务接受者，可在本合同的框架内，自行协商和签署各方之间的合同。与本合同有冲突的，应当以各方的合同内容为准。两方之间的合同关系，除非经第三方同意并确认，不得损害本三方合同中第三方的权益。\n" +
            "\n" +
            "第十七条 服务接受者与向导协商一致，可以变更约定的服务内容，但应当以书面形式进行确认。因此增加的相应费用及给对方造成的损失，由变更提出方承担，因此减少的费用，应退还服务接受者。向导与服务接受者变更向导服务合同的，应及时通知平台，服务接受者重新通过平台进行预订有关向导服务，如向导服务费用增加的，平台有权以向导向服务接受者实际提供向导服务的总费用为基础收取服务费，如向导服务费用减少的，平台不向向导或服务接受者退还任何费用。否则向导应向试点机构承担两倍服务费违约责任，平台有权从向导交纳的保证金中直接扣除或向向导进行追偿。\n" +
            "\n" +
            "第十八条 经向导与服务接受者协商一致转让导游服务合同的，应及时通知平台，否则后续产生的一切事宜由向导与服务接受者自行承担。\n" +
            "\n" +
            "第五章 合同解除\n" +
            "\n" +
            "第十九条 平台、向导及服务接受者可以书面等形式解除本合同及其他与向导服务相关的合同，但应承担相应的违约责任。\n" +
            "\n" +
            "第二十条 向导与服务接受者协商一致，解除合同的，应通知平台。\n" +
            "\n" +
            "第二十一条 平台与向导协商一致，解除合同的；或平台依据与向导之间的协议单方解除合同的，可将向导在平台中的相关信息删除，如该向导有未完成的向导服务合同或订单的，平台应及时通知服务接受者，平台除向服务接受者退还其已支付但未享受的服务之外的费用外不再承担其他任何责任。\n" +
            "\n" +
            "第二十二条 除各方另有约定外，合同解除后，涉及退款的，以支付方式的路径退回，并需要遵守第三方支付机构相关退款规则、期限。\n" +
            "\n" +
            "第六章 合同各方权利义务\n" +
            "\n" +
            "第二十三条  各方权利义务条款由以下部分组成：\n" +
            "\n" +
            "23.1 各方在本三方合同第二章中的承诺与声明条款。\n" +
            "\n" +
            "23.2 在本三方合同中体现各方权利义务的其他条款。\n" +
            "\n" +
            "23.3 各方在本章中以下条款规定的权利义务。\n" +
            "\n" +
            "23.4 各方在两两之间的合同中约定的权利义务。\n" +
            "\n" +
            "第二十四条 平台的权利\n" +
            "\n" +
            "24.1 平台有权拒绝与违反法律法规或平台相关制度的向导合作，拒绝该类向导在本平台开展向导自由执业业务；平台有权拒绝为违反法律法规或平台相关制度的服务接受者提供相关服务。\n" +
            "\n" +
            "24.2 若向导存在侵犯平台利益、违反平台经营秩序的行为，平台有权解除与向导签署的任何合同，并要求向导承担相应的责任。\n" +
            "\n" +
            "24.3 平台可根据向导服务质量和服务接受者的评价情况，制定相应的奖惩规则，但不应侵犯向导的正当权益。\n" +
            "\n" +
            "24.4 平台有权以向导接单的情况、服务接受者反馈的评价等相关数据作为参考，对平台上注册的向导进行评分或排名。\n" +
            "\n" +
            "24.5平台在因向导责任向服务接受者等受害方承担先行赔付责任后，可依法、依约向向导追偿。\n" +
            "\n" +
            "24.6平台代收旅游接受者向向导支付的服务费。\n" +
            "\n" +
            "第二十五条 平台的义务\n" +
            "\n" +
            "25.1 平台应为已完成注册的向导、服务接受者提供用户账号和登录密码，并保证交易系统的便利、安全。\n" +
            "\n" +
            "25.2 审核向导的资料和信息，客观真实地展示向导信息。一旦发现存在虚假信息或侵犯第三人合法权益等，平台有权立即删除。\n" +
            "\n" +
            "25.3 平台代收向导服务费的，应当按照约定及时向向导支付，不得侵占或无故拖延。\n" +
            "\n" +
            "25.5 因向导存在故意、重大过失等责任，需要向服务接受者承担责任的，平台应按照4.3条承担先行赔偿的责任。\n" +
            "\n" +
            "25.7 尊重向导与服务接受者双方的交易自由；交易过程中，若双方发生任何矛盾或纠纷，任何一方皆可依据平台的规则，申请平台介入调解；调解不成的，平台应尊重向导或服务接受者采取合法途径维护自身权益的权利。\n" +
            "\n" +
            "第二十六条  向导的权利\n" +
            "\n" +
            "26.1 可选择在一家或多家平台进行注册并开展向导自由执业。\n" +
            "\n" +
            "26.2 按照相应的约定获得向导服务报酬的权利；\n" +
            "\n" +
            "26.3有权要求旅游者健康文明旅游，劝阻旅游者违法和违反社会公德的行为。\n" +
            "\n" +
            "26.4 对下列情形之一的要求，自由执业的向导人员有权拒绝：\n" +
            "\n" +
            "26.4.1 侮辱其人格尊严的要求；\n" +
            "\n" +
            "26.4.2 违反其职业道德的不合理要求；\n" +
            "\n" +
            "26.4.3 与我国民族风俗习惯不符的要求；\n" +
            "\n" +
            "26.4.4 可能危害其人身安全的要求；\n" +
            "\n" +
            "26.4.5 法律、法规和规章禁止的其他行为。\n" +
            "\n" +
            "第二十七条 向导的义务\n" +
            "\n" +
            "27.1 服从平台的合理管理及安排。\n" +
            "\n" +
            "27.2 妥善保管平台交付的用户名和登录密码，并对因保管不善造成的后果承担责任。\n" +
            "\n" +
            "27.3向导在平台上展示的个人资料应真实、准确，且不侵犯他人权益。\n" +
            "\n" +
            "27.4 向导不得在取得服务接受者的信息后，强迫或者诱导服务接受者取消平台上的订单转为私下交易，或未经服务接受者同意私自变更向导；\n" +
            "\n" +
            "27.5 按照约定的内容和标准为服务接受者提供服务，不擅自改变服务内容或降低服务标准。\n" +
            "\n" +
            "27.6 依法对服务接受者个人信息/商业秘密保密；依法对在开展自由执业过程中获得的平台商业秘密保密。\n" +
            "\n" +
            "27.7 向导应对向导服务中可能危及服务接受者人身、财务安全的情况，进行说明和警示；遇紧急情况时，带有应采取安全救助措施。\n" +
            "\n" +
            "27.8 在向导服务接受后，向导应当尊重服务接受者在平台上对向导的客观评价、评分。不得干涉服务接受者按照真实意愿对向导的评价。\n" +
            "\n" +
            "27.9向导应按照与服务接受者的合同约定提供相应的向导服务，不得违反《中华人民共和国旅游法》，包括但不限于，擅自增加或减少服务接受者的人数，变更服务内容，强制服务接受者参加购物或自费项目等。\n" +
            "\n" +
            "27.10向导提供服务期间不得擅自向服务接受者强制推销旅游产品，如服务接受者主动咨询的，向导不得推荐除在携程旅行网上售卖之外的其他旅游产品。\n" +
            "\n" +
            "27.11向导应严格遵守平台不时发布的各类规则，所有规则与本协议具有同等法律效力，且平台对本协议和规则有权进行修改，如向导不同意平台所做的修改，则有权停止使用平台服务，如继续使用平台服务，则视为向导接受本平台所做的修改。\n" +
            "\n" +
            "27.12如服务接受者需要开具发票的，应由向导直接向服务接受者提供。\n" +
            "\n" +
            "第二十八条  服务接受者的权利\n" +
            "\n" +
            "28.1 服务接受者有权在平台上自主选择向导提供相应的服务；向导、平台不得强迫或变相强迫服务接受者购买、接受平台、向导推送的服务。\n" +
            "\n" +
            "28.2 服务接受者有权知悉其购买的向导服务的真实情况，并要求对方对相应的格式条款及服务做出说明。\n" +
            "\n" +
            "28.3 有权要求平台、向导按照合同约定提供相应的服务。\n" +
            "\n" +
            "28.4 有权就其与平台的纠纷以及向导违反合同约定或侵犯自己合法权益的行为，向平台、消费者权益保护部门投诉。\n" +
            "\n" +
            "28.5 在接受向导服务后，有权依据自身的主观感受，在平台上对向导服务情况进行评分、评价。\n" +
            "\n" +
            "28.6 有权拒绝向导未经协商委托其他向导履行合同的行为。\n" +
            "\n" +
            "第二十九条 服务接受者的义务\n" +
            "\n" +
            "29.1 在向平台申请个人账户、签订合同和填写各种材料时，应当使用有效证件，并对填写信息的真实性、有效性负责。不得故意隐瞒个人信息或身体和健康情况；如处于妊娠期、70周岁以上、18周岁以下或有身体残障、患有高血压、心脏病等疾病，非中国国籍或为港澳台人士等的，应如实告之平台或向导。否则由此产生的相关后果和责任由服务接受者自行承担。\n" +
            "\n" +
            "29.2 按照约定支付向导服务费用、承担向导开展工作必需的门票费用、交通费用等。\n" +
            "\n" +
            "29.3应充分履行合同中约定的责任和义务，遵守旅游活动安全警示，配合有关部门或向导采取安全防范和应急措施。\n" +
            "\n" +
            "29.4 发生纠纷时，应采取适当措施防止损失扩大，不损害平台、向导的合法权益，不损害他人的合法权益。\n" +
            "\n" +
            "29.5 在向导服务结束后，服务接受者在平台上对向导的评分、评价，应当客观、公正，不得故意诋毁向导，不得歪曲事实、侮辱向导人格。\n" +
            "\n" +
            "29.6若服务接受者为法人或其他组织的，应为向导提供安全、有序、健康的执业环境，并为其完成服务提供必要的支持和配合。向导在服务过程中造成损失或侵害后果的，该法人或组织应先行承担相关的赔付责任。\n" +
            "\n" +
            "29.7 向导服务接受者为旅行社的，应如实告之向导、平台实际接受向导服务的旅游团（者）的相关情况，包括但不限于游客国籍、省份、数量、旅游行程安排，需要向导服务的时间段和区域，对向导服务的特殊要求等。\n" +
            "\n" +
            "29.8服务接受者应确保其具备正常出行的各项条件，包括但不限于，身体健康条件适宜参加高原地区旅游或风险旅游项目或未患有不宜出行旅游的病情；具备正常出入境的护照、签证、签注等有效证件，如因发生不可抗力、意外事件、航班取消、航班延误、签证未及时出签等任何非平台及向导的原因导致本合同项下的向导服务受到正常使用的，平台有权拒绝退还服务接受者已支付的向导服务费。\n" +
            "\n" +
            "29.9服务接受者在接受向导服务过程中应严加注意人身及财产安全，平台除在本合同约定范围内承担先行赔付责任外，不再承担其他法律责任或赔偿义务。\n" +
            "\n" +
            "第七章 委托与授权\n" +
            "\n" +
            "第三十条 如需要受托人代表委托人签署本合同以及相关附件的，受托人应保证取得相应合法授权并保证其在本合同中确认、签章，能够代表委托人对合同的认可。委托人享有合同权利并承担合同责任和义务。\n" +
            "\n" +
            "第三十一条 因委托人与受托人之间委托事项产生的纠纷，由委托人和受托人协商解决，与其他各方无关。\n" +
            "\n" +
            "第八章 基于线上平台交易的特别约定\n" +
            "\n" +
            "第三十二条 向导和服务接受者均可自行通过个人账户在平台上发布个人信息或对向导服务的评价，但应遵循相关法律法规，不得在平台上发布以下内容：\n" +
            "\n" +
            "（1）   反对中华人民共和国宪法所确定的基本原则的。\n" +
            "（2）   危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的。\n" +
            "（3）   损害国家荣誉和利益的。\n" +
            "（4）   煽动民族仇恨、民族歧视，破坏民族团结的。\n" +
            "（5）   破坏国家宗教政策，宣扬邪教和封建迷信的。\n" +
            "（6）   散布谣言，扰乱社会秩序，破坏社会稳定的。\n" +
            "（7）   散步淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的、欺诈性的或以其它令人反感的信息的。\n" +
            "（8）   侮辱或者诽谤他人，侵害他人合法权益的。\n" +
            "（9）   侵犯他人知识产权或专有权利的。\n" +
            "（10）  假冒他人信息的内容、侵犯他人姓名权、名称权、肖像权的。\n" +
            "（11）  未经平台同意而擅自发布的促销信息、广告、政治言论或进行意见征集的。\n" +
            "（12）  任何第三方的私人信息，包括但不限于地址、电话号码、电子邮件地址、身份证号以及信用卡卡号。\n" +
            "（13）  病毒、不可靠数据或其它有害的、破坏性的或危害性的文件。\n" +
            "（14）  与所在的互动区域的话题不相关的内容。\n" +
            "（15）  包含法律或行政法规禁止内容的。\n" +
            "\n" +
            "第三十三条 平台保留经自行裁决和判断而过滤、编辑或移除任何上述内容的权利。\n" +
            "\n" +
            "第三十四条 因系统维护或升级的需要而需暂停网络服务的，平台将尽可能在网站上进行通告。由于向导、服务接受者未能及时获取通告信息而造成的损失，平台不承担任何责任。\n" +
            "\n" +
            "第三十五条 向导和服务接受者向平台上传的一起信息，将被视为非保密的，平台无义务将此等内容作为专有信息对待，平台有权利按照平台的模板做必要编辑，并视同授权平台在合理范围内使用。\n" +
            "\n" +
            "第三十六条 平台、向导在使用由服务接受者提供的或者向导自行拍摄的任何关乎服务接受者的影响图片资料时，须经服务接受者授权后方可使用，否则将承担因侵害服务接受者肖像权、著作权等一系列相关权利所造成的损失。\n" +
            "\n" +
            "第三十七条 向导和服务接受者在平台注册成功后，应妥善保管平台为其提供的用户名和登录密码。向导和服务接受者应当对该用户名和密码承担全部的责任。\n" +
            "\n" +
            "第三十八条 因黑客行为、计算机病毒侵入或发作或等导致用户名、密码被他人非法使用、盗用、篡改的或丢失的，平台不承担责任。\n" +
            "\n" +
            "第三十九 合同各方应确保上述联系方式的畅通有效，如一方变更本合同指定的联系人和联系方式，应提前三日通知另外两方，否则由变更承担由此造成的一起后果和责任。\n" +
            "\n" +
            "第九章 违约责任\n" +
            "\n" +
            "第四十条  合同各方均应严格按照本合同的约定履行各自义务、承担各自责任。因一方违反本合同约定，给另外一方或双方造成损害的，应承担相应的赔偿责任。\n" +
            " \n" +
            "第四十一条 如按比例支付违约金后仍不足以赔偿向导的实际损失的，服务接受者应按实际损失支付，但最高不得超过全部向导服务费及为保障向导服务所花费的全部费用。向导应提供相关材料证明其损失与服务接受者违约行为存在直接、必然的因果关系且已造成了直接经济损失。\n" +
            "\n" +
            "第四十二条 向导未经服务接受者同意，委托他人履行合同的，视为向导解除合同，由向导向服务接受者全额退还向导费用，并承担向导服务费用30%的违约责任，如经服务接受者同意的除外。\n" +
            "\n" +
            "第四十三条 平台发现向导和服务接受者脱离平台自行交易的，平台有权单方解除本合同，要求向导和服务接受者承担相应违约责任，平台有权以向导向服务接受者实际提供向导服务的总费用为基础收取服务费。否则向导应向平台承担两倍服务费的违约责任，平台有权从向导交纳的保证金中直接扣除或向向导进行追偿。\n" +
            "\n" +
            "第四十四条 在合同履行过程中一方违约后，另一方应当采取必要措施防止损失扩大，否则应就扩大的损失承担责任。\n" +
            " \n" +
            "第十章 法律适用\n" +
            " \n" +
            "第四十七条 本合同的签订、履行和争议解决均适用中华人民共和国现行有效法律、法规、部门规章和有关司法解释。\n" +
            " \n" +
            "第五十条 各方另行签署的合同、协议、补充条款、或书面协议，不违反法律、法规强制性规定的，为本合同的必要组成部分，与本合同具有同等法律效力。\n";
}
