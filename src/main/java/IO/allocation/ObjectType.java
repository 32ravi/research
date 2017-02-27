package IO.allocation;

/*
 * For memory allocation test i will use 13 byte of message & it is broken down into
 - int - 4 byte
 - long - 8 byte
 - byte - 1 byte
 */
public interface ObjectType {
	
	//navigate method is going to set starting position in side the byte buffer.
    public void navigate(int index);

    public void setInt(int value);

    public void setLong(long value);

    public void setByte(byte value);

    public int getInt();

    public long getLong();

    public byte getByte();
}
