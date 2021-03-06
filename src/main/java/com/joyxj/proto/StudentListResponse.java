// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.joyxj.proto;

/**
 * Protobuf type {@code com.joyxj.proto.StudentListResponse}
 */
public  final class StudentListResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.joyxj.proto.StudentListResponse)
    StudentListResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StudentListResponse.newBuilder() to construct.
  private StudentListResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StudentListResponse() {
    studentResonse_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StudentListResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              studentResonse_ = new java.util.ArrayList<com.joyxj.proto.StudentResponse>();
              mutable_bitField0_ |= 0x00000001;
            }
            studentResonse_.add(
                input.readMessage(com.joyxj.proto.StudentResponse.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        studentResonse_ = java.util.Collections.unmodifiableList(studentResonse_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.joyxj.proto.StudentProto.internal_static_com_joyxj_proto_StudentListResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.joyxj.proto.StudentProto.internal_static_com_joyxj_proto_StudentListResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.joyxj.proto.StudentListResponse.class, com.joyxj.proto.StudentListResponse.Builder.class);
  }

  public static final int STUDENTRESONSE_FIELD_NUMBER = 1;
  private java.util.List<com.joyxj.proto.StudentResponse> studentResonse_;
  /**
   * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
   */
  public java.util.List<com.joyxj.proto.StudentResponse> getStudentResonseList() {
    return studentResonse_;
  }
  /**
   * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
   */
  public java.util.List<? extends com.joyxj.proto.StudentResponseOrBuilder> 
      getStudentResonseOrBuilderList() {
    return studentResonse_;
  }
  /**
   * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
   */
  public int getStudentResonseCount() {
    return studentResonse_.size();
  }
  /**
   * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
   */
  public com.joyxj.proto.StudentResponse getStudentResonse(int index) {
    return studentResonse_.get(index);
  }
  /**
   * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
   */
  public com.joyxj.proto.StudentResponseOrBuilder getStudentResonseOrBuilder(
      int index) {
    return studentResonse_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < studentResonse_.size(); i++) {
      output.writeMessage(1, studentResonse_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < studentResonse_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, studentResonse_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.joyxj.proto.StudentListResponse)) {
      return super.equals(obj);
    }
    com.joyxj.proto.StudentListResponse other = (com.joyxj.proto.StudentListResponse) obj;

    boolean result = true;
    result = result && getStudentResonseList()
        .equals(other.getStudentResonseList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getStudentResonseCount() > 0) {
      hash = (37 * hash) + STUDENTRESONSE_FIELD_NUMBER;
      hash = (53 * hash) + getStudentResonseList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.joyxj.proto.StudentListResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.joyxj.proto.StudentListResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.joyxj.proto.StudentListResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.joyxj.proto.StudentListResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.joyxj.proto.StudentListResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.joyxj.proto.StudentListResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.joyxj.proto.StudentListResponse)
      com.joyxj.proto.StudentListResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.joyxj.proto.StudentProto.internal_static_com_joyxj_proto_StudentListResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.joyxj.proto.StudentProto.internal_static_com_joyxj_proto_StudentListResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.joyxj.proto.StudentListResponse.class, com.joyxj.proto.StudentListResponse.Builder.class);
    }

    // Construct using com.joyxj.proto.StudentListResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getStudentResonseFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (studentResonseBuilder_ == null) {
        studentResonse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        studentResonseBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.joyxj.proto.StudentProto.internal_static_com_joyxj_proto_StudentListResponse_descriptor;
    }

    public com.joyxj.proto.StudentListResponse getDefaultInstanceForType() {
      return com.joyxj.proto.StudentListResponse.getDefaultInstance();
    }

    public com.joyxj.proto.StudentListResponse build() {
      com.joyxj.proto.StudentListResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.joyxj.proto.StudentListResponse buildPartial() {
      com.joyxj.proto.StudentListResponse result = new com.joyxj.proto.StudentListResponse(this);
      int from_bitField0_ = bitField0_;
      if (studentResonseBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          studentResonse_ = java.util.Collections.unmodifiableList(studentResonse_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.studentResonse_ = studentResonse_;
      } else {
        result.studentResonse_ = studentResonseBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.joyxj.proto.StudentListResponse) {
        return mergeFrom((com.joyxj.proto.StudentListResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.joyxj.proto.StudentListResponse other) {
      if (other == com.joyxj.proto.StudentListResponse.getDefaultInstance()) return this;
      if (studentResonseBuilder_ == null) {
        if (!other.studentResonse_.isEmpty()) {
          if (studentResonse_.isEmpty()) {
            studentResonse_ = other.studentResonse_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureStudentResonseIsMutable();
            studentResonse_.addAll(other.studentResonse_);
          }
          onChanged();
        }
      } else {
        if (!other.studentResonse_.isEmpty()) {
          if (studentResonseBuilder_.isEmpty()) {
            studentResonseBuilder_.dispose();
            studentResonseBuilder_ = null;
            studentResonse_ = other.studentResonse_;
            bitField0_ = (bitField0_ & ~0x00000001);
            studentResonseBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getStudentResonseFieldBuilder() : null;
          } else {
            studentResonseBuilder_.addAllMessages(other.studentResonse_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.joyxj.proto.StudentListResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.joyxj.proto.StudentListResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.joyxj.proto.StudentResponse> studentResonse_ =
      java.util.Collections.emptyList();
    private void ensureStudentResonseIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        studentResonse_ = new java.util.ArrayList<com.joyxj.proto.StudentResponse>(studentResonse_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.joyxj.proto.StudentResponse, com.joyxj.proto.StudentResponse.Builder, com.joyxj.proto.StudentResponseOrBuilder> studentResonseBuilder_;

    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public java.util.List<com.joyxj.proto.StudentResponse> getStudentResonseList() {
      if (studentResonseBuilder_ == null) {
        return java.util.Collections.unmodifiableList(studentResonse_);
      } else {
        return studentResonseBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public int getStudentResonseCount() {
      if (studentResonseBuilder_ == null) {
        return studentResonse_.size();
      } else {
        return studentResonseBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public com.joyxj.proto.StudentResponse getStudentResonse(int index) {
      if (studentResonseBuilder_ == null) {
        return studentResonse_.get(index);
      } else {
        return studentResonseBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder setStudentResonse(
        int index, com.joyxj.proto.StudentResponse value) {
      if (studentResonseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResonseIsMutable();
        studentResonse_.set(index, value);
        onChanged();
      } else {
        studentResonseBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder setStudentResonse(
        int index, com.joyxj.proto.StudentResponse.Builder builderForValue) {
      if (studentResonseBuilder_ == null) {
        ensureStudentResonseIsMutable();
        studentResonse_.set(index, builderForValue.build());
        onChanged();
      } else {
        studentResonseBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder addStudentResonse(com.joyxj.proto.StudentResponse value) {
      if (studentResonseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResonseIsMutable();
        studentResonse_.add(value);
        onChanged();
      } else {
        studentResonseBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder addStudentResonse(
        int index, com.joyxj.proto.StudentResponse value) {
      if (studentResonseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResonseIsMutable();
        studentResonse_.add(index, value);
        onChanged();
      } else {
        studentResonseBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder addStudentResonse(
        com.joyxj.proto.StudentResponse.Builder builderForValue) {
      if (studentResonseBuilder_ == null) {
        ensureStudentResonseIsMutable();
        studentResonse_.add(builderForValue.build());
        onChanged();
      } else {
        studentResonseBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder addStudentResonse(
        int index, com.joyxj.proto.StudentResponse.Builder builderForValue) {
      if (studentResonseBuilder_ == null) {
        ensureStudentResonseIsMutable();
        studentResonse_.add(index, builderForValue.build());
        onChanged();
      } else {
        studentResonseBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder addAllStudentResonse(
        java.lang.Iterable<? extends com.joyxj.proto.StudentResponse> values) {
      if (studentResonseBuilder_ == null) {
        ensureStudentResonseIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, studentResonse_);
        onChanged();
      } else {
        studentResonseBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder clearStudentResonse() {
      if (studentResonseBuilder_ == null) {
        studentResonse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        studentResonseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public Builder removeStudentResonse(int index) {
      if (studentResonseBuilder_ == null) {
        ensureStudentResonseIsMutable();
        studentResonse_.remove(index);
        onChanged();
      } else {
        studentResonseBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public com.joyxj.proto.StudentResponse.Builder getStudentResonseBuilder(
        int index) {
      return getStudentResonseFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public com.joyxj.proto.StudentResponseOrBuilder getStudentResonseOrBuilder(
        int index) {
      if (studentResonseBuilder_ == null) {
        return studentResonse_.get(index);  } else {
        return studentResonseBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public java.util.List<? extends com.joyxj.proto.StudentResponseOrBuilder> 
         getStudentResonseOrBuilderList() {
      if (studentResonseBuilder_ != null) {
        return studentResonseBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(studentResonse_);
      }
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public com.joyxj.proto.StudentResponse.Builder addStudentResonseBuilder() {
      return getStudentResonseFieldBuilder().addBuilder(
          com.joyxj.proto.StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public com.joyxj.proto.StudentResponse.Builder addStudentResonseBuilder(
        int index) {
      return getStudentResonseFieldBuilder().addBuilder(
          index, com.joyxj.proto.StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.joyxj.proto.StudentResponse studentResonse = 1;</code>
     */
    public java.util.List<com.joyxj.proto.StudentResponse.Builder> 
         getStudentResonseBuilderList() {
      return getStudentResonseFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.joyxj.proto.StudentResponse, com.joyxj.proto.StudentResponse.Builder, com.joyxj.proto.StudentResponseOrBuilder> 
        getStudentResonseFieldBuilder() {
      if (studentResonseBuilder_ == null) {
        studentResonseBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.joyxj.proto.StudentResponse, com.joyxj.proto.StudentResponse.Builder, com.joyxj.proto.StudentResponseOrBuilder>(
                studentResonse_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        studentResonse_ = null;
      }
      return studentResonseBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.joyxj.proto.StudentListResponse)
  }

  // @@protoc_insertion_point(class_scope:com.joyxj.proto.StudentListResponse)
  private static final com.joyxj.proto.StudentListResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.joyxj.proto.StudentListResponse();
  }

  public static com.joyxj.proto.StudentListResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StudentListResponse>
      PARSER = new com.google.protobuf.AbstractParser<StudentListResponse>() {
    public StudentListResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StudentListResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StudentListResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StudentListResponse> getParserForType() {
    return PARSER;
  }

  public com.joyxj.proto.StudentListResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

