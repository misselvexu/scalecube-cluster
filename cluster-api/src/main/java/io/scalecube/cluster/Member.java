package io.scalecube.cluster;

import io.scalecube.net.Address;
import java.util.Objects;
import java.util.UUID;

/**
 * Cluster member which represents node in the cluster and contains its id and address. This class
 * is essentially immutable.
 */
public final class Member {

  private String id;
  private Address address;

  /** Instantiates empty member for deserialization purpose. */
  Member() {}

  /**
   * Create instance of cluster member by given address; member id will be generated by {@link
   * #generateId()}.
   *
   * @param address address on which given member listens for incoming messages
   */
  public Member(Address address) {
    this(generateId(), address);
  }

  /**
   * Create instance of cluster member with given parameters.
   *
   * @param id member id
   * @param address address on which given member listens for incoming messages
   */
  public Member(String id, Address address) {
    this.id = Objects.requireNonNull(id);
    this.address = Objects.requireNonNull(address);
  }

  public String id() {
    return id;
  }

  public Address address() {
    return address;
  }

  private static String generateId() {
    return Long.toHexString(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null || getClass() != that.getClass()) {
      return false;
    }
    Member member = (Member) that;
    return Objects.equals(id, member.id) && Objects.equals(address, member.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address);
  }

  @Override
  public String toString() {
    return id + "@" + address;
  }
}
