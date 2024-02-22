public interface TechnicalErrorCodes {
    String e0x01 = "e0x01 - The input data appears to be null or marked as 0 bytes, causing an inability to handle the processing.";
    String e0x02 = "e0x02 - The program has hit a critical error, input is in an unsupported format for this operation. Process halted at breakpoint.";
    String e0x11 = "e0x11 - Illegal state encountered. The program is in an unexpected state and cannot proceed.";
    String e0x21 = "e0x21 - Incorrect or corrupt file metadata requested or posted by the program. Process halted at breakpoint.";
    String e0x22 = "e0x22 - The file pointer appears to be null, or marked as 0 bytes, causing an inability to handle the processing. (Maybe the files at file/ are empty?)";
    String e0x91 = "e0x91 - An unknown error has been reported by the MySQL instance.";
}
