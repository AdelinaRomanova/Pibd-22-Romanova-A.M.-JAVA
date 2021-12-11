public enum RocketsEnum {
    Two,
    Four,
    Six;
    public static RocketsEnum setEnumNumber(int number)
    {
        switch (number) {
            case 0:
                return RocketsEnum.Two;
            case 1:
                return RocketsEnum.Four;
            case 2:
                return RocketsEnum.Six;
        }
        return null;
    }
}