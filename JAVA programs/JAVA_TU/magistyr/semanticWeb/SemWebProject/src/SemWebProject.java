import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

public class SemWebProject {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Model model = ModelFactory.createDefaultModel();
		model = FileManager.get().loadModel("cloudStructures.owl");
		Dataset data = DatasetFactory.create(model);

		try {
			//queryToExecute1(data);
			//queryToExecute2(data);
			queryToExecute3(data);
		} finally {
			model.close();
			data.close();
		}
	}

	private static void queryToExecute1(Dataset dataset) {
		String queryText1 = "PREFIX cs: <http://www.semanticweb.org/user/ontologies/2020/11/untitled-ontology-11#> "
				+ "SELECT ?saas "
				+ "WHERE { "
				+ " ?saas cs:hasSupportType ?SupportTypeWorkDays. "
				+ "}";

		Query query = QueryFactory.create(queryText1);
		QueryExecution queryexec = QueryExecutionFactory.create(query, dataset);

		try {
			ResultSet results = queryexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				Resource saas = solution.getResource("saas");

				System.out.println(saas);
			}
		} finally {
			queryexec.close();
			dataset.close();
		}
	}

	private static void queryToExecute2(Dataset dataset) {
		String queryText2 = "PREFIX cs: <http://www.semanticweb.org/user/ontologies/2020/11/untitled-ontology-11#> "
				+ "SELECT ?saas ?price "
				+ " WHERE { "
				+ "     ?saas cs:hasPrice ?price."
				+ "  	FILTER (?price > 300.5)."
				+ " }  ORDER BY ?price";

		Query query = QueryFactory.create(queryText2);
		QueryExecution queryexec = QueryExecutionFactory.create(query, dataset);

		try {
			ResultSet results = queryexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();

				System.out.println(solution.getResource("saas"));
				
				Literal price = solution.getLiteral("price");
				System.out.println(price.getDouble());
			}
		} finally {
			queryexec.close();
			dataset.close();
		}
	}

	private static void queryToExecute3(Dataset dataset) {
		String queryText3 = "PREFIX cs: <http://www.semanticweb.org/user/ontologies/2020/11/untitled-ontology-11#> "
				+ "SELECT ?saas ?price "
				+ "WHERE { "
				+ "   ?saas cs:hasPaymentType cs:MonthlyFee. "
				+ "   ?saas cs:hasPrice ?price. "
				+ "}";

		Query query = QueryFactory.create(queryText3);
		QueryExecution queryexec = QueryExecutionFactory.create(query, dataset);

		try {
			ResultSet results = queryexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				
				System.out.println(solution.getResource("saas"));
				
				Literal price = solution.getLiteral("price");
				
				if(price != null) {
					System.out.println(price.getDouble());
				}
			}
		} finally {
			queryexec.close();
			dataset.close();
		}
	}
}
