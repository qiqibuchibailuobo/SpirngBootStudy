package cn.yq.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address  {

  private static final long serialVersionUID = -8985545025228238771L;

  String city;
  String country;

  public Address(String city, String country) {
    this.city = city;
    this.country = country;
  }
}