public enum RocketsEnum {
    Two,
    Four,
    Six;
    public static RocketsEnum setEnumNumber(int number)
    {
        switch (number) {
            case 2:
                return RocketsEnum.Two;
            case 4:
                return RocketsEnum.Four;
            case 6:
                return RocketsEnum.Six;
        }
        return null;
    }
}