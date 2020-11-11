import java.util.List;

public class Main {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            List<LottoNumber> lotto = LottoFactory.createLottoNumbers();
            System.out.println(lotto);
        }
    }
}
