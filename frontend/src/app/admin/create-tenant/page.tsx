'use client';

import { useState } from 'react';
import { useRouter } from 'next/navigation';
import styles from './create-tenant.module.css';

export default function CreateTenant() {
    const router = useRouter();
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        address: '',
        apiKey: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        // TODO: Call API
        console.log('Creating tenant:', formData);
        // await fetch(`${process.env.NEXT_PUBLIC_API_URL}/tenants`, { method: 'POST', body: JSON.stringify(formData) });

        alert('Tenant created successfully (Mock)');
        router.push('/admin');
    };

    return (
        <div className={styles.container}>
            <h1>Onboard New Tenant</h1>
            <form onSubmit={handleSubmit} className={styles.form}>
                <div className={styles.formGroup}>
                    <label htmlFor="name">Tenant Name</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className={styles.formGroup}>
                    <label htmlFor="email">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className={styles.formGroup}>
                    <label htmlFor="address">Address</label>
                    <input
                        type="text"
                        id="address"
                        name="address"
                        value={formData.address}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className={styles.formGroup}>
                    <label htmlFor="apiKey">Fiserv API Key (Mock)</label>
                    <input
                        type="text"
                        id="apiKey"
                        name="apiKey"
                        value={formData.apiKey}
                        onChange={handleChange}
                    />
                </div>

                <button type="submit" className={styles.submitButton}>Create Tenant</button>
            </form>
        </div>
    );
}
