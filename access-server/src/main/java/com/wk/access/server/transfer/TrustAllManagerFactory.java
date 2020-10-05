package com.wk.access.server.transfer;

import javax.net.ssl.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;

public  class TrustAllManagerFactory extends TrustManagerFactory {
	private static final Provider PROVIDER = new Provider("", 0.0, "") {
          private static final long serialVersionUID = -2680540247105807895L;
      };

      /**
        * {@link TrustAllManagerFactorySpi} must have a reference to {@link TrustAllManagerFactory}
        * to delegate its callbacks back to {@link TrustAllManagerFactory}.  However, it is impossible to do so,
        * because {@link TrustManagerFactory} requires {@link TrustManagerFactorySpi} at construction time and
        * does not provide a way to access it later.
        *
        * To work around this issue, we use an ugly hack which uses a {@link ThreadLocal}.
        */
        private static final TrustAllManagerFactorySpi CURRENT_SPI= new TrustAllManagerFactorySpi();
//		private static final FastThreadLocal<TrustAllManagerFactorySpi> CURRENT_SPI =
//            new FastThreadLocal<TrustAllManagerFactorySpi>() {
//                  @Override
//                  protected TrustAllManagerFactorySpi initialValue() {
//                      return new TrustAllManagerFactorySpi();
//                  }
//              };

      /**
       * Creates a new instance.
       */
      public TrustAllManagerFactory() {
          this("");
      }

      /**
       * Creates a new instance.
       *
       * @param name the name of this {@link TrustManagerFactory}
       */
      public TrustAllManagerFactory(String name) {
          super(CURRENT_SPI, PROVIDER, name);
          CURRENT_SPI.init(this);
          if (name == null) {
              throw new NullPointerException("name");
          }
      }

      /**
       * Initializes this factory with a source of certificate authorities and related trust material.
       *
       * @see TrustManagerFactorySpi#engineInit(KeyStore)
       */
      public void engineInit(KeyStore keyStore) throws Exception{
          
      };

      /**
       * Initializes this factory with a source of provider-specific key material.
       *
       * @see TrustManagerFactorySpi#engineInit(ManagerFactoryParameters)
       */
      public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception{
          
        };

      /**
       * Returns one trust manager for each type of trust material.
       *
       * @see TrustManagerFactorySpi#engineGetTrustManagers()
       */
      public  TrustManager[] engineGetTrustManagers(){
          TrustManager[] trustAllCerts = new TrustManager[1];
          TrustManager tm = new X509TrustAllManager();
          trustAllCerts[0] = tm;
          return trustAllCerts;             
      }

     static final class TrustAllManagerFactorySpi extends TrustManagerFactorySpi {

         private TrustAllManagerFactory parent;
         private volatile TrustManager[] trustManagers;

         void init(TrustAllManagerFactory parent) {
             this.parent = parent;
         }

         @Override
         protected void engineInit(KeyStore keyStore) throws KeyStoreException {
             try {
                 parent.engineInit(keyStore);
             } catch (KeyStoreException e) {
                throw e;
            } catch (Exception e) {
                 throw new KeyStoreException(e);
            }
       }

       @Override
         protected void engineInit(
                 ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
             try {
                 parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e) {
                 throw e;
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException(e);
             }
         }

        @Override
         protected TrustManager[] engineGetTrustManagers() {
             TrustManager[] trustManagers = this.trustManagers;
             if (trustManagers == null) {
                trustManagers = parent.engineGetTrustManagers();
                for (int i = 0; i < trustManagers.length; i++) {
                     final TrustManager tm = trustManagers[i];
                     if (tm instanceof X509TrustManager ) {
                         trustManagers[i] = new X509TrustAllManager();
                    }
                 }

                this.trustManagers = trustManagers;
           }
            return trustManagers.clone();
        }
     }

}
