package code.src.main.java.cli;
import code.src.main.java.valueobjects.L2Protocol;





public class Interpreter implements CLIInterpreter{

        private int bytes;
        private boolean padding = false;

    @Override
    public InputValues convertArguments(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("?") || args[i].equals("--help")){

                return new code.src.main.java.valueobjects.InputValues(-1, null, false, true);
            }
            if (args[i].equals("--gui")){

                return new code.src.main.java.valueobjects.InputValues(true);
            }
            if (args[i].equals("-B")){
                if (++i >= args.length){
                    return null;
                }
                bytes = getBytes(args[i + 1]);
            }
            if(args[i].equals("-P")){
                padding= true;
            }
            if (args[i].equals("-L2") || args[i].equals("--l2-protocol")){
                if (++i >= args.length){
                    return null;
                }

            }
        }
    }
    private L2Protocol[]  readL2Protocol(String[] args, int offset){

        int index;
        for(index = 0; index + offset < args.length; index++ ){
            if (!(args[index + offset].equals("AAL5-ATM") ||args[index + offset].equals("AAL3/4-ATM") || args[index + offset].equals("Ethernet"))){
                break;
            }
        }
        L2Protocol[] arrayL2 = new L2Protocol[index];
        int i;
        for(i = 0; i <= index; i++ ){

            if (args[i].equals("AAL5-ATM")){
                arrayL2[i] = L2Protocol.AAL5_ATM;
            }
            if (args[i].equals("AAL3/4-ATM")){
                arrayL2[i] = L2Protocol.AAL3_4_ATM;
            }
            if (args[i].equals("Ethernet")){
                arrayL2[i] = L2Protocol.ETHERNET;
            }
        }

        return arrayL2;
    }

    private int getBytes(String arg) {
        int kb = 1024;
        int mb = kb * 1024;
        int gb = mb * 1024;
        int tb = gb * 1024;
        int pb = tb * 1024;
        arg.toUpperCase();
        int bytes = -1;
        try{
            if (arg.endsWith("KB")){ // implement kilobytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*kb);
            } else if (arg.endsWith("MB")){ // implement megabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*mb);
            } else if (arg.endsWith("GB")){ // implement gigabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*gb);
            } else if (arg.endsWith("TB")){ // implement terrabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*tb);
            } else if (arg.endsWith("PB")){ // implement petabytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-2))*pb);
            } else if (arg.endsWith("B")){ // implement bytes
                bytes = (Integer.parseInt(arg.substring(0, arg.length()-1)));
            } else { // implement lonely numbers
                bytes = Integer.parseInt(arg);
            }
        } catch (NumberFormatException e){ // given string is not convertible to a number
            return -1;
        }
        return bytes;
    }
}