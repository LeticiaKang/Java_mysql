public class TermProjectDemo {
    public static void main(String[] args){
        System.out.println("선택");

        TermProjectPolls polls = new TermProjectPolls();
        int val = polls.PollFunction();
        
        TermProjectStatics statics = new TermProjectStatics();
        val = statics.StaticsFunction();
        
        return;
    }
}
