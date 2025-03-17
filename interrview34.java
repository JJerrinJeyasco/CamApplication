import java.io.*;

class KeyboardReader extends DataInputStream
{
    KeyboardReader()
    {
        super(System.in);
    }
        public int scanInteger() throws IOException
        {
            return
        Integer.parseInt(super.readLine());
        }
}
class interrview34
{
    public static void main(String []args) throws IOException
    {
        KeyboardReader key=new KeyboardReader();
        int a=key.scanInteger();
        System.out.println(a);
    }
}
