public class Strinteger implements StrintegerInterface{
    private short[] setval = new short[8];
    @Override
    public String encrint(long value) {
        String strinteger;
        value = Long.reverseBytes(Long.reverse(value));
        for (byte part = 7; part >= 0; part--) {
            for (byte partt = 7; partt >= 0; partt--) {
                setval[part] <<= 1;
                setval[part] += value & 1;
                value >>= 1;
            }
        }
        strinteger = "";
        for (short bb : setval) {
            strinteger += Character.toString(bb);
        }
        return strinteger;
    }
    @Override
    public long decrint(String strinteger) {
        char[] listeger = strinteger.toCharArray();
        long number = 0;
        for(char c : listeger) {
            number = number << 8;
            number += ((int) c);
        }
        return number;
    }
}