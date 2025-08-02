// Company Service for API calls
const API_BASE_URL =
  import.meta.env.VITE_BASE_URL || "http://localhost:8080/api/companies";

class CompanyService {
  // Create a new company
  async createCompany(companyData) {
    try {
      const response = await fetch(API_BASE_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(companyData),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || "Failed to create company");
      }

      return await response.json();
    } catch (error) {
      console.error("Error creating company:", error);
      throw error;
    }
  }

  // Get all companies
  async getAllCompanies() {
    try {
      const response = await fetch(API_BASE_URL);

      if (!response.ok) {
        throw new Error("Failed to fetch companies");
      }

      const result = await response.json();
      return result.data || [];
    } catch (error) {
      console.error("Error fetching companies:", error);
      throw error;
    }
  }

  // Get company by ID
  async getCompanyById(id) {
    try {
      const response = await fetch(`${API_BASE_URL}/${id}`);

      if (!response.ok) {
        throw new Error("Failed to fetch company");
      }

      const result = await response.json();
      return result.data;
    } catch (error) {
      console.error("Error fetching company:", error);
      throw error;
    }
  }

  // Update company
  async updateCompany(id, companyData) {
    try {
      const response = await fetch(`${API_BASE_URL}/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(companyData),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || "Failed to update company");
      }

      return await response.json();
    } catch (error) {
      console.error("Error updating company:", error);
      throw error;
    }
  }

  // Delete company
  async deleteCompany(id) {
    try {
      const response = await fetch(`${API_BASE_URL}/${id}`, {
        method: "DELETE",
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || "Failed to delete company");
      }

      return await response.json();
    } catch (error) {
      console.error("Error deleting company:", error);
      throw error;
    }
  }

  // Search companies by name
  async searchCompanies(searchTerm) {
    try {
      const response = await fetch(
        `${API_BASE_URL}/search?name=${encodeURIComponent(searchTerm)}`
      );

      if (!response.ok) {
        throw new Error("Failed to search companies");
      }

      const result = await response.json();
      return result.data || [];
    } catch (error) {
      console.error("Error searching companies:", error);
      throw error;
    }
  }
}

export default new CompanyService();
