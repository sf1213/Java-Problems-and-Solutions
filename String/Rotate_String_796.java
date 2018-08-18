package String;

public class Rotate_String_796 {
	public boolean rotateString(String A, String B) {
        return (A.length() ==B.length()) && (A + A).contains(B);
    }
}
