package fr.spark.pfe.test_doubles;


import fr.spark.pfe.fake.dao.EmailService;

public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail(String message) {
      throw new AssertionError("Method not implementes !!!");
    }
}
