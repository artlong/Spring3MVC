package annotation.javaeyer;

@Description("javaeye,做最棒的軟件開發交流社區")
public class JavaEyer {
	@Name(originate = "創始人:robbin", community = "javaEye")
	public String getName() {
		return null;
	}

	@Name(originate = "創始人:江南白衣", community = "springside")
	public String getName2() {
		return "借用兩位的id一用,寫這一個例子,請見諒!";
	}
}