// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greet.proto

package assignment1.grpc.grpc;

public final class Greet {
  private Greet() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_Greeting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_GreetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_GreetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_GreetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_GreetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_Messages_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_Messages_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013greet.proto\022\004grpc\"5\n\010Greeting\022\014\n\004from\030" +
      "\001 \001(\t\022\n\n\002to\030\002 \001(\t\022\017\n\007message\030\003 \001(\t\"0\n\014Gr" +
      "eetRequest\022 \n\010greeting\030\001 \001(\0132\016.grpc.Gree" +
      "ting\"\037\n\rGreetResponse\022\016\n\006result\030\001 \001(\t\",\n" +
      "\010Messages\022 \n\010messages\030\001 \003(\0132\016.grpc.Greet" +
      "ing\"\007\n\005Empty2\236\001\n\014GreetService\0222\n\005Greet\022\022" +
      ".grpc.GreetRequest\032\023.grpc.GreetResponse\"" +
      "\000\022,\n\013SendMessage\022\016.grpc.Greeting\032\013.grpc." +
      "Empty\"\000\022,\n\013GetMessages\022\013.grpc.Empty\032\016.gr" +
      "pc.Messages\"\000B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_grpc_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_Greeting_descriptor,
        new java.lang.String[] { "From", "To", "Message", });
    internal_static_grpc_GreetRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_GreetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_GreetRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_grpc_GreetResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_grpc_GreetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_GreetResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_grpc_Messages_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_grpc_Messages_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_Messages_descriptor,
        new java.lang.String[] { "Messages", });
    internal_static_grpc_Empty_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_grpc_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}