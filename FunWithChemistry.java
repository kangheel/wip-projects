public class FunWithChemistry {
    private static AtomicMassTable table = new AtomicMassTable();
    private double moleculeWeight;
    public FunWithChemistry(String element) {
        moleculeWeight = getMoleculeWeight(element);
    }
	public static double elementWeight(String element) {
    	if (Character.isDigit(element.charAt(1))) {
        	double weight = table.get(element.substring(0,1));
        	return weight*Integer.parseInt(element.substring(1,2));
    	}
    	else if (element.length() > 2 && Character.isDigit(element.charAt(2))) {
        	double weight = table.get(element.substring(0,2));
        	return weight*Integer.parseInt(element.substring(2,3));
    	}
    	if (element.length() == 1) {
        	return table.get(element.substring(0,1));
    	}
    	return table.get(element.substring(0,2));
	}
	public static double getMoleculeWeight(String molecule) {
    	double sum = 0;
    	int i = 0;
    	int index = 1;
    	while (molecule.length() > 0) {
        	index = 1;
        	if (Character.isLetter(molecule.charAt(0)) && Character.isLetter(molecule.charAt(1))) {
            	index = 2;
        	}
        	double weight = table.get(molecule.substring(0,index));
        	String num = "";
        	i = index;
        	while (i < molecule.length() && !Character.isLetter(molecule.charAt(i))) {
            	num += molecule.substring(i,i+1);
            	i++;
        	}
        	int count = 1;
        	if (num.length() != 0) {
            	count = Integer.parseInt(num);
        	}
        	sum += count*weight;
        	molecule = molecule.substring(i);
    	}
    	return sum;
	}
	public static double molesToGram(String molecule, double moles) {
    	return getMoleculeWeight(molecule)*moles;
	}
	public static double gramToMoles(String molecule, double weight) {
    	return weight/getMoleculeWeight(molecule);
	}
}