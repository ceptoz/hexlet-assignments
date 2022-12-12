package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String charSequence;
    private String reversedSequence;

    public ReversedSequence(String charSequence) {
        this.charSequence = charSequence;
    }

    private String getReversedSequence() {
        StringBuilder reversedSequence = new StringBuilder();
        if (charSequence.equals("")) {
            return "";
        }
        for (int i = 0; i < charSequence.length(); i++) {
            reversedSequence.append(charSequence.charAt(charSequence.length() - i - 1));
        }
        return reversedSequence.toString();
    }

    @Override
    public String toString() {
        return getReversedSequence();
    }

    @Override
    public int length() {
        return getReversedSequence().length();
    }

    @Override
    public char charAt(int i) {
        return getReversedSequence().charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return getReversedSequence().substring(i, i1);
    }
}
// END
