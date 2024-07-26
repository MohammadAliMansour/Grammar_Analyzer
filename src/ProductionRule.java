public record ProductionRule(String left, String right) {

    @Override
    public String toString() {
        return ":{" +
                "left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }
}
