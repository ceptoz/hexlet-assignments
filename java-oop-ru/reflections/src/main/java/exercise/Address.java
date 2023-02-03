package exercise;

class Address {
    @NotNull
    @MinLength(minLength = 4)
    private final String country;
    @NotNull
    private final String city;
    @NotNull
    private final String street;
    @NotNull
    private final String houseNumber;
    private final String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
