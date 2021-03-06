/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.je.demo.app.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TestEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -243562592528701985L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TestEvent\",\"namespace\":\"com.je.demo.app.avro\",\"fields\":[{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"counter\",\"type\":\"int\"},{\"name\":\"timeToProcess\",\"type\":\"long\"},{\"name\":\"error\",\"type\":\"boolean\"},{\"name\":\"topic\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TestEvent> ENCODER =
      new BinaryMessageEncoder<TestEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TestEvent> DECODER =
      new BinaryMessageDecoder<TestEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TestEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TestEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TestEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TestEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TestEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TestEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TestEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TestEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence username;
   private int counter;
   private long timeToProcess;
   private boolean error;
   private java.lang.CharSequence topic;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TestEvent() {}

  /**
   * All-args constructor.
   * @param username The new value for username
   * @param counter The new value for counter
   * @param timeToProcess The new value for timeToProcess
   * @param error The new value for error
   * @param topic The new value for topic
   */
  public TestEvent(java.lang.CharSequence username, java.lang.Integer counter, java.lang.Long timeToProcess, java.lang.Boolean error, java.lang.CharSequence topic) {
    this.username = username;
    this.counter = counter;
    this.timeToProcess = timeToProcess;
    this.error = error;
    this.topic = topic;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return username;
    case 1: return counter;
    case 2: return timeToProcess;
    case 3: return error;
    case 4: return topic;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: username = (java.lang.CharSequence)value$; break;
    case 1: counter = (java.lang.Integer)value$; break;
    case 2: timeToProcess = (java.lang.Long)value$; break;
    case 3: error = (java.lang.Boolean)value$; break;
    case 4: topic = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'username' field.
   * @return The value of the 'username' field.
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }


  /**
   * Sets the value of the 'username' field.
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'counter' field.
   * @return The value of the 'counter' field.
   */
  public int getCounter() {
    return counter;
  }


  /**
   * Sets the value of the 'counter' field.
   * @param value the value to set.
   */
  public void setCounter(int value) {
    this.counter = value;
  }

  /**
   * Gets the value of the 'timeToProcess' field.
   * @return The value of the 'timeToProcess' field.
   */
  public long getTimeToProcess() {
    return timeToProcess;
  }


  /**
   * Sets the value of the 'timeToProcess' field.
   * @param value the value to set.
   */
  public void setTimeToProcess(long value) {
    this.timeToProcess = value;
  }

  /**
   * Gets the value of the 'error' field.
   * @return The value of the 'error' field.
   */
  public boolean getError() {
    return error;
  }


  /**
   * Sets the value of the 'error' field.
   * @param value the value to set.
   */
  public void setError(boolean value) {
    this.error = value;
  }

  /**
   * Gets the value of the 'topic' field.
   * @return The value of the 'topic' field.
   */
  public java.lang.CharSequence getTopic() {
    return topic;
  }


  /**
   * Sets the value of the 'topic' field.
   * @param value the value to set.
   */
  public void setTopic(java.lang.CharSequence value) {
    this.topic = value;
  }

  /**
   * Creates a new TestEvent RecordBuilder.
   * @return A new TestEvent RecordBuilder
   */
  public static com.je.demo.app.avro.TestEvent.Builder newBuilder() {
    return new com.je.demo.app.avro.TestEvent.Builder();
  }

  /**
   * Creates a new TestEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TestEvent RecordBuilder
   */
  public static com.je.demo.app.avro.TestEvent.Builder newBuilder(com.je.demo.app.avro.TestEvent.Builder other) {
    if (other == null) {
      return new com.je.demo.app.avro.TestEvent.Builder();
    } else {
      return new com.je.demo.app.avro.TestEvent.Builder(other);
    }
  }

  /**
   * Creates a new TestEvent RecordBuilder by copying an existing TestEvent instance.
   * @param other The existing instance to copy.
   * @return A new TestEvent RecordBuilder
   */
  public static com.je.demo.app.avro.TestEvent.Builder newBuilder(com.je.demo.app.avro.TestEvent other) {
    if (other == null) {
      return new com.je.demo.app.avro.TestEvent.Builder();
    } else {
      return new com.je.demo.app.avro.TestEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for TestEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TestEvent>
    implements org.apache.avro.data.RecordBuilder<TestEvent> {

    private java.lang.CharSequence username;
    private int counter;
    private long timeToProcess;
    private boolean error;
    private java.lang.CharSequence topic;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.je.demo.app.avro.TestEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.username)) {
        this.username = data().deepCopy(fields()[0].schema(), other.username);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.counter)) {
        this.counter = data().deepCopy(fields()[1].schema(), other.counter);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.timeToProcess)) {
        this.timeToProcess = data().deepCopy(fields()[2].schema(), other.timeToProcess);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.error)) {
        this.error = data().deepCopy(fields()[3].schema(), other.error);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.topic)) {
        this.topic = data().deepCopy(fields()[4].schema(), other.topic);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing TestEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.je.demo.app.avro.TestEvent other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.username)) {
        this.username = data().deepCopy(fields()[0].schema(), other.username);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.counter)) {
        this.counter = data().deepCopy(fields()[1].schema(), other.counter);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timeToProcess)) {
        this.timeToProcess = data().deepCopy(fields()[2].schema(), other.timeToProcess);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.error)) {
        this.error = data().deepCopy(fields()[3].schema(), other.error);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.topic)) {
        this.topic = data().deepCopy(fields()[4].schema(), other.topic);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'username' field.
      * @return The value.
      */
    public java.lang.CharSequence getUsername() {
      return username;
    }


    /**
      * Sets the value of the 'username' field.
      * @param value The value of 'username'.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.username = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'username' field has been set.
      * @return True if the 'username' field has been set, false otherwise.
      */
    public boolean hasUsername() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'username' field.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder clearUsername() {
      username = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'counter' field.
      * @return The value.
      */
    public int getCounter() {
      return counter;
    }


    /**
      * Sets the value of the 'counter' field.
      * @param value The value of 'counter'.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder setCounter(int value) {
      validate(fields()[1], value);
      this.counter = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'counter' field has been set.
      * @return True if the 'counter' field has been set, false otherwise.
      */
    public boolean hasCounter() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'counter' field.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder clearCounter() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'timeToProcess' field.
      * @return The value.
      */
    public long getTimeToProcess() {
      return timeToProcess;
    }


    /**
      * Sets the value of the 'timeToProcess' field.
      * @param value The value of 'timeToProcess'.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder setTimeToProcess(long value) {
      validate(fields()[2], value);
      this.timeToProcess = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'timeToProcess' field has been set.
      * @return True if the 'timeToProcess' field has been set, false otherwise.
      */
    public boolean hasTimeToProcess() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'timeToProcess' field.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder clearTimeToProcess() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'error' field.
      * @return The value.
      */
    public boolean getError() {
      return error;
    }


    /**
      * Sets the value of the 'error' field.
      * @param value The value of 'error'.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder setError(boolean value) {
      validate(fields()[3], value);
      this.error = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'error' field has been set.
      * @return True if the 'error' field has been set, false otherwise.
      */
    public boolean hasError() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'error' field.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder clearError() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'topic' field.
      * @return The value.
      */
    public java.lang.CharSequence getTopic() {
      return topic;
    }


    /**
      * Sets the value of the 'topic' field.
      * @param value The value of 'topic'.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder setTopic(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.topic = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'topic' field has been set.
      * @return True if the 'topic' field has been set, false otherwise.
      */
    public boolean hasTopic() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'topic' field.
      * @return This builder.
      */
    public com.je.demo.app.avro.TestEvent.Builder clearTopic() {
      topic = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TestEvent build() {
      try {
        TestEvent record = new TestEvent();
        record.username = fieldSetFlags()[0] ? this.username : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.counter = fieldSetFlags()[1] ? this.counter : (java.lang.Integer) defaultValue(fields()[1]);
        record.timeToProcess = fieldSetFlags()[2] ? this.timeToProcess : (java.lang.Long) defaultValue(fields()[2]);
        record.error = fieldSetFlags()[3] ? this.error : (java.lang.Boolean) defaultValue(fields()[3]);
        record.topic = fieldSetFlags()[4] ? this.topic : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TestEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<TestEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TestEvent>
    READER$ = (org.apache.avro.io.DatumReader<TestEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.username);

    out.writeInt(this.counter);

    out.writeLong(this.timeToProcess);

    out.writeBoolean(this.error);

    out.writeString(this.topic);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);

      this.counter = in.readInt();

      this.timeToProcess = in.readLong();

      this.error = in.readBoolean();

      this.topic = in.readString(this.topic instanceof Utf8 ? (Utf8)this.topic : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);
          break;

        case 1:
          this.counter = in.readInt();
          break;

        case 2:
          this.timeToProcess = in.readLong();
          break;

        case 3:
          this.error = in.readBoolean();
          break;

        case 4:
          this.topic = in.readString(this.topic instanceof Utf8 ? (Utf8)this.topic : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










