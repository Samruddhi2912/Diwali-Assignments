public class CodingChallenge {

    // Method 1: Using regex to check if string is alphanumeric
    public static boolean isAlphanumericRegex(String str) {
        if (str == null) return false;
        return str.matches("^[a-zA-Z0-9]+$");
    }

    // Method 2: Checking each character manually
    public static boolean isAlphanumericManual(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "Hello123",    // true
            "Hello_123",   // false (underscore)
            "123456",      // true
            "Hello 123",   // false (space)
            "!@#",        // false (special chars)
            ""             // false (empty string)
        };
        
        System.out.println("Using regex approach:");
        for (String s : testStrings) {
            System.out.println("'" + s + "' is alphanumeric? " + isAlphanumericRegex(s));
        }
        
        System.out.println("\nUsing manual character checking:");
        for (String s : testStrings) {
            System.out.println("'" + s + "' is alphanumeric? " + isAlphanumericManual(s));
        }
    }
}
