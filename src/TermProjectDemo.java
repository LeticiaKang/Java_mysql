public class TermProjectDemo {
    public static void main(String[] args){
        System.out.println("선택");

        TermProjectPolls polls = new TermProjectPolls();
        TermProjectStatics statics = new TermProjectStatics();

        int val = polls.PollFunction();
        int val2 = statics.StaticsFunction();

        return;
    }
}
