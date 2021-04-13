import java.util.ArrayList;
import java.util.Scanner;

public class ArticleView {

    private ArticlePresenter ap;

    public ArticleView() {

    }

    public void displayArticles(ArrayList<Article> articles) {
        for (Article art : articles) {
            System.out.println(art.getName() + " : " + Math.abs(art.getPrice()));
        }
        System.out.println();
    }

    public void awaitInput() {
        boolean run = true;
        while (run) {
            Scanner userInput = new Scanner(System.in);  // Create a Scanner object
            System.out.println("i : iterate");
            System.out.println("a : add random article");
            System.out.println("q : quit");

            String userChoice = userInput.nextLine();

            if (ap != null) {
                switch (userChoice) {
                    case "i" :
                        ap.iterate();
                        break;
                    case "a" :
                        ap.addArticle();
                        break;
                    case "q" :
                        run = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public ArticlePresenter getAp() {
        return ap;
    }

    public void setAp(ArticlePresenter ap) {
        this.ap = ap;
    }
}
