
package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        setTitle("Reserve Your Ideal Holiday");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // Create the navigation bar
        JPanel navBar = createNavigationBar();
        add(navBar, BorderLayout.NORTH);

        // Create main content panel
        JPanel mainContent = createMainContent();
        add(mainContent, BorderLayout.CENTER);
    } 
    
    
    
    
    
    private JPanel createNavigationBar() {
        JPanel navBar = new JPanel();
        navBar.setLayout(new BorderLayout());
        navBar.setBackground(Color.WHITE);
        navBar.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        // Left side of navbar (Logo and navigation links)
        JPanel leftNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        leftNav.setBackground(Color.WHITE);

        // Logo (you'll need to replace with actual logo)
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/icons/logo.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(60, 45, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(logoImg));
        leftNav.add(logo);

        // Navigation links
        String[] navItems = {"Home", "Rooms"};
        for (String item : navItems) {
            JButton navButton = createNavButton(item);
            leftNav.add(navButton);
        }

        // Right side of navbar (Contact Us and Profile)
        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20,0));
        rightNav.setBackground(Color.WHITE);
        
        JButton contactButton = createContactButton();
        rightNav.add(contactButton);

        navBar.add(leftNav, BorderLayout.WEST);
        navBar.add(rightNav, BorderLayout.EAST);

        return navBar;
    }
    
    
    
    
    
    private JButton createContactButton() {
        JButton contactButton = new JButton("Reserve");
        contactButton.setFont(new Font("Arial", Font.PLAIN, 14));
        contactButton.setPreferredSize(new Dimension(120, 35));
        contactButton.setBackground(new Color(245, 245, 245));
        contactButton.setForeground(Color.BLACK);
        contactButton.setFocusPainted(false);
        
        // Create a compound border with rounded corners using LineBorder
        contactButton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1, true),  // Outer border (rounded)
            BorderFactory.createEmptyBorder(5, 15, 5, 15)  // Inner padding
        ));
        
        // Add hover effect
        contactButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                contactButton.setBackground(new Color(235, 235, 235));
            }
            
            public void mouseExited(MouseEvent e) {
                contactButton.setBackground(new Color(245, 245, 245));
            }
        });
        
        contactButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return contactButton;
    }
      
        
        
        
        
    private JPanel createProfileIcons() {
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, -10, 0));
        profilePanel.setBackground(Color.WHITE);

        String[] profilePaths = {"/icons/profile1.jpg", "/icons/profile2.jpg", "/icons/profile3.jpg"};
        for (String path : profilePaths) {
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            JLabel profile = new JLabel(new ImageIcon(img));
            profile.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            profilePanel.add(profile);
        }

        return profilePanel;
    }
    
    
    
    
    
    private JPanel createMainContent() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 40, 40));

        // Header Section
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel("Reserve Your Room");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        JLabel subtitleLabel = new JLabel("For a Ideal Holiday");
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        
        JLabel taglineLabel = new JLabel("Let's get acquainted!");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(taglineLabel);

        
        JPanel profileIconsPanel = createProfileIcons();
        profileIconsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
   
        // Stats Panel
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 10));
        statsPanel.setBackground(Color.WHITE);
        
        addStat(statsPanel, "115k+", "Capital Raised");
        addStat(statsPanel, "70k+", "Happy Customers");
        addStat(statsPanel, "47K+", "Property Options");

        // Property Cards Panel
        JPanel cardsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        cardsPanel.setBackground(Color.WHITE);
        cardsPanel.setMaximumSize(new Dimension(1300, 500)); // Control maximum size
        cardsPanel.setPreferredSize(new Dimension(1200, 450));
        
        // Add property cards
        cardsPanel.add(createPropertyCard(
            "Essouira",
            "Charming streets, fresh seafood, and ocean breezes await in Essaouira. Experience the magic of this historic coastal gem!",
            5,
            "/icons/essaouira.jpg"  // Replace with actual image path
        ));
        
        cardsPanel.add(createPropertyCard(
            "Agadir",
            "Sunny beaches, vibrant souks, and breathtaking views—Agadir has it all. Come relax and explore this coastal paradise!",
            5,
            "/icons/agadir.jpg" // Replace with actual image path
        ));

        mainPanel.add(headerPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(profileIconsPanel); // Add profile icons panel
        mainPanel.add(statsPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(cardsPanel);

        return mainPanel;
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        return button;
    }

    private void addStat(JPanel panel, String number, String label) {
        JPanel statPanel = new JPanel();
        statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
        statPanel.setBackground(Color.WHITE);
        
        JLabel numberLabel = new JLabel(number);
        numberLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        JLabel textLabel = new JLabel(label);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        textLabel.setForeground(Color.GRAY);
        
        statPanel.add(numberLabel);
        statPanel.add(Box.createVerticalStrut(5));
        statPanel.add(textLabel);
        
        panel.add(statPanel);
    }

    
    private JPanel createPropertyCard(String location, String description, int stars, String imagePath) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new RoundedBorder(20));

        // Create image panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);

        try {
            // Load and resize image
            ImageIcon propertyIcon = new ImageIcon(getClass().getResource(imagePath));
            Image propertyImg = propertyIcon.getImage();

            // Calculate aspect ratio to maintain image proportions
            int targetWidth = 500;
            int targetHeight = 250;

            Image scaledImg = propertyImg.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
            imageLabel.setPreferredSize(new Dimension(targetWidth, targetHeight));

            // Center the image in the panel
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
            e.printStackTrace();
            // Fallback if image fails to load
            JLabel placeholder = new JLabel("Image not found");
            placeholder.setPreferredSize(new Dimension(500, 250));
            placeholder.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(placeholder, BorderLayout.CENTER);
        }

        card.add(imagePanel, BorderLayout.CENTER);

        // Info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel locationLabel = new JLabel(location);
        locationLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel descriptionLabel = new JLabel("<html><body style='width: 300px'>" + description + "</html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        infoPanel.add(locationLabel);
        if (stars > 0) {
            JPanel starsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            starsPanel.setBackground(Color.WHITE);
            for (int i = 0; i < stars; i++) {
                JLabel star = new JLabel("★");
                star.setForeground(Color.ORANGE);
                starsPanel.add(star);
            }
            infoPanel.add(starsPanel);
        }
        infoPanel.add(Box.createVerticalStrut(8));
        infoPanel.add(descriptionLabel);

        card.add(infoPanel, BorderLayout.SOUTH);
        return card;
    }

    
    // Custom rounded border class
    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
