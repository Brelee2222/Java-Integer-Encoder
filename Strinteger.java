public class Strinteger implements StrintegerInterface{
    private String strinteger;
    private short[] setval = new short[8];
    private boolean negative;
    @Override
    public void set(long value) {
        if(value >= 0)
            negative = true;
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
    }
    @Override
    public long get() {
        char[] listeger = strinteger.toCharArray();
        long number = 0;
        for(char c : listeger) {
            number = number << 8;
            number += ((int) c);
        }
        return number;
    }
}