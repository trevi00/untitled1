package sol._01_base;

public class _01_CharacterType {
    public static void main(String[] args) {
        
        // Chracter(문자) 자료형
        // Java, C# -> 2byte(16bit) -> UTF-16
        // C, C++ -> 1 byte(8bit) -> UTF-8
        
        long num1 = 12345678900L;
        long num2 = 1000; // long으로 선언했지만 L또는 l이 선언되어 있지 않으면 int로 자동 형변환

        System.out.println(num1);
        System.out.println(num2);
        
        
    }
}
