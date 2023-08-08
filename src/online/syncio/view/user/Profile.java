package online.syncio.view.user;

import online.syncio.view.user.Main;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import online.syncio.component.ProfilePostPanel;
import online.syncio.controller.user.ProfileController;
import online.syncio.dao.MongoDBConnect;
import online.syncio.dao.UserDAO;
import online.syncio.model.LoggedInUser;
import online.syncio.model.User;
import online.syncio.model.UserIDAndDate;
import online.syncio.utils.ImageHelper;
import online.syncio.utils.OtherHelper;

public class Profile extends JPanel {

    private Image defaultImage = new javax.swing.ImageIcon(getClass().getResource("/online/syncio/resources/images/icons/avt_128px.png")).getImage();

    private Main main = Main.getInstance();
    private UserDAO userDAO = MongoDBConnect.getUserDAO();

    private ProfileController controller;

    public Profile(User user) {
        initComponents();
        setBackground(new Color(0f, 0f, 0f, 0f));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        controller = new ProfileController(this);

        controller.loadProfile(user);
    }

    public void loadOwnProfile(User user) {
        btnEditProfileMessage.setText("Edit profile");
        btnFollow.setVisible(false);

        lblAvatar.setSize(128, 128);
        ImageIcon resizeImg = ImageHelper.resizing(defaultImage, lblAvatar.getWidth(), lblAvatar.getHeight());
        lblAvatar.setIcon(ImageHelper.toRoundImage(resizeImg, lblAvatar.getWidth()));
    }

    public void loadOtherUserProfile(User user) {
        btnEditProfileMessage.setText("Message");
        btnFollow.setVisible(true);

        ArrayList<UserIDAndDate> following = LoggedInUser.getCurrentUser().getFollowing();
        boolean followingUser = false;

        // Check if the logged-in user is following the shown user
        for (UserIDAndDate u : following) {
            if (u.getUserID().equals(user.getId().toString())) {
                btnFollow.setText("Unfollow");
                followingUser = true;
                break;
            }
        }

        if (!followingUser) {
            btnFollow.setText("Follow");
        }
    }

    public void setProfileInfo(User user) {
        String username = user.getUsername();
        String bio = user.getBio();
        int postNum = controller.getPostListSize();
        int followersSize = user.getFollowing().size();

        lblUsername.setText(username);
        lblUsername.setToolTipText(username);
        lblBio.setText(bio);
        lblPostNum.setText(postNum + " posts");
        lblFollowingNum.setText(followersSize + " following");
        lblFollowerNum.setText(userDAO.getFollowerCount(user.getId().toString()) + " followers");
    }

    public void toggleFollow() {
        if (btnFollow.getText().equalsIgnoreCase("follow")) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }
    }

    public ProfilePostPanel getPnlProfilePost() {
        return pnlProfilePost;
    }

    public ProfileController getController() {
        return controller;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new online.syncio.component.MyScrollPane();
        pnlMain = new online.syncio.component.MyPanel();
        btnEditProfileMessage = new online.syncio.component.MyButton();
        lblSepratorLine = new javax.swing.JLabel();
        lblUsername = new online.syncio.component.MyLabel();
        lblPostNum = new online.syncio.component.MyProfileFollowLabel();
        lblFollowerNum = new online.syncio.component.MyProfileFollowLabel();
        lblFollowingNum = new online.syncio.component.MyProfileFollowLabel();
        lblPost = new online.syncio.component.MyLabel();
        pnlProfilePost = new online.syncio.component.ProfilePostPanel();
        lblBio = new online.syncio.component.MyLabel();
        lblAvatar = new online.syncio.component.MyLabel();
        btnFollow = new online.syncio.component.MyButton();

        setLayout(new java.awt.BorderLayout());

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setMaximumSize(new java.awt.Dimension(1080, 679));
        scrollPane.setMinimumSize(new java.awt.Dimension(1080, 679));
        scrollPane.setPreferredSize(new java.awt.Dimension(1080, 679));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setRoundBottomRight(20);

        btnEditProfileMessage.setBackground(new java.awt.Color(239, 239, 239));
        btnEditProfileMessage.setText("Edit profile");
        btnEditProfileMessage.setBorderColor(new java.awt.Color(239, 239, 239));
        btnEditProfileMessage.setRadius(10);
        btnEditProfileMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileMessageActionPerformed(evt);
            }
        });

        lblSepratorLine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 228, 228), 2));
        lblSepratorLine.setPreferredSize(new java.awt.Dimension(2, 1));

        lblUsername.setText("56duong");
        lblUsername.setToolTipText("");
        lblUsername.setFont(new java.awt.Font("SF Pro Display Medium", 0, 18)); // NOI18N

        lblPostNum.setText("0 posts");

        lblFollowerNum.setText("0 followers");

        lblFollowingNum.setText("5 following");

        lblPost.setText("POSTS");
        lblPost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnlProfilePost.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfilePost.setOpaque(true);

        lblBio.setText("adele.com");

        lblAvatar.setOpaque(true);

        btnFollow.setBackground(new java.awt.Color(0, 149, 246));
        btnFollow.setForeground(new java.awt.Color(255, 255, 255));
        btnFollow.setText("Follow");
        btnFollow.setBorderColor(new java.awt.Color(0, 149, 246));
        btnFollow.setRadius(10);
        btnFollow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFollowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPostNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFollowerNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditProfileMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFollow, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFollowingNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSepratorLine, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                            .addComponent(pnlProfilePost, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(lblPost, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnEditProfileMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnFollow, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPostNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFollowerNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFollowingNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(lblBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(lblSepratorLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lblPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProfilePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        scrollPane.setViewportView(pnlMain);

        add(scrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditProfileMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileMessageActionPerformed
        if (btnEditProfileMessage.getText().equalsIgnoreCase("edit profile")) {
            if(OtherHelper.getMainAdmin(this) != null && OtherHelper.getMainAdmin(this).isVisible()) {
                CardLayout c = (CardLayout) OtherHelper.getMainAdmin(this).getPnlTabContent().getLayout();
                c.show(OtherHelper.getMainAdmin(this).getPnlTabContent(), "editprofile");
            }
            else {
                CardLayout c = (CardLayout) this.main.getPnlTabContent().getLayout();
                c.show(this.main.getPnlTabContent(), "editprofile");
            }
        }

        if (btnEditProfileMessage.getText().equalsIgnoreCase("message")) {
            CardLayout c = (CardLayout) this.main.getPnlTabContent().getLayout();
            c.show(this.main.getPnlTabContent(), "message");

            this.main.getMessagePanel().getController().openMessage(lblUsername.getText().trim());
        }
    }//GEN-LAST:event_btnEditProfileMessageActionPerformed

    private void btnFollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFollowActionPerformed
        int result = userDAO.toggleFollow(LoggedInUser.getCurrentUser().getId().toString(), controller.getUser().getId().toString());
        if (result > 0) {
            toggleFollow();
            lblFollowerNum.setText(userDAO.getFollowerCount(controller.getUser().getId().toString()) + " followers");
        } else {
            System.out.println(result);
        }
    }//GEN-LAST:event_btnFollowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private online.syncio.component.MyButton btnEditProfileMessage;
    private online.syncio.component.MyButton btnFollow;
    private online.syncio.component.MyLabel lblAvatar;
    private online.syncio.component.MyLabel lblBio;
    private online.syncio.component.MyProfileFollowLabel lblFollowerNum;
    private online.syncio.component.MyProfileFollowLabel lblFollowingNum;
    private online.syncio.component.MyLabel lblPost;
    private online.syncio.component.MyProfileFollowLabel lblPostNum;
    private javax.swing.JLabel lblSepratorLine;
    private online.syncio.component.MyLabel lblUsername;
    private online.syncio.component.MyPanel pnlMain;
    private online.syncio.component.ProfilePostPanel pnlProfilePost;
    private online.syncio.component.MyScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
