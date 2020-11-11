import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for(int i=MIN_LOTTO_NUMBER; i<=MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> createLottoNumbers() {
        List<LottoNumber> lotto = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for(int i=0; i<LOTTO_LENGTH; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        return lotto;
    }
}

class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}