package com.hexaware.FTP112.factory;

import com.hexaware.FTP112.persistence.WalletDAO;
import com.hexaware.FTP112.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP112.model.Wallet;
import com.hexaware.FTP112.util.Validators;
/**
 * WalletFactory class used to fetch Wallet data from database.
 * @author hexware
 */
public class WalletFactory {
  /**
   *  Protected constructor.
   */
  protected WalletFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static WalletDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Wallet object.
   * @param cusId to initialize customer Id.
   */
  public static List<Wallet> showWallet(final int cusId) {
    List<Wallet> wallet = dao().show(cusId);
    return wallet;
  }
  /**
   * @return Wallet amount.
   * @param walletId to initialize wallet amount.
   */
  public static double getWalletBalance(final int walletId) {
    Validators.validateWalletId(walletId);
    double walAmount = dao().getWalletAmount(walletId);
    return walAmount;
  }
  /**
   * @param totalOrderPrice to initialize total Order Price.
   * @param cusId to initialize wallet cus Id.
   * @param walletId to initialize wallet id.
   */
  public static void updateWalletAmount(final double totalOrderPrice, final int cusId, final int walletId) {
    dao().WalletAmount(totalOrderPrice, cusId, walletId);
  }
  /**
   * @param price to initialize total Order Price.
   * @param customerId to initialize  cus Id.
   * @param walletId to initialize wallet id.
   */
  public static void refundAmount(final double price, final int customerId, final int walletId) {
    dao().refundAmount(price, customerId, walletId);
  }
  /**
   * @return Wallet amount.
   * @param walletId to initialize wallet amount.
   */
  public static int findByWalletId(final int walletId) {
    int id = dao().fetchWalletId(walletId);
    return id;
  }
}
