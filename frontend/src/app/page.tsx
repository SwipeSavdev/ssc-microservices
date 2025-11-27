import Link from 'next/link';
import styles from './page.module.css';

export default function Home() {
  return (
    <div className={styles.container}>
      <main className={styles.main}>
        <h1 className={styles.title}>
          Multi-Tenant <span className={styles.highlight}>Rewards</span> Platform
        </h1>

        <p className={styles.description}>
          Enterprise-grade loyalty and banking solutions for your business.
        </p>

        <div className={styles.grid}>
          <Link href="/tenant/signup" className={styles.card}>
            <h2>Tenant Portal &rarr;</h2>
            <p>Onboard your business, manage accounts, and configure rewards.</p>
          </Link>

          <Link href="/customer/signup" className={styles.card}>
            <h2>Customer Portal &rarr;</h2>
            <p>Sign up, view your balance, and manage your virtual cards.</p>
          </Link>

          <Link href="/admin" className={styles.card}>
            <h2>Admin Console &rarr;</h2>
            <p>System administration and tenant management.</p>
          </Link>
        </div>
      </main>

      <footer className={styles.footer}>
        <p>Powered by Fiserv & Spring Boot Microservices</p>
      </footer>
    </div>
  );
}
