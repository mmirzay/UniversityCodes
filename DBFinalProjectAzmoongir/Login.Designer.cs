namespace Azmoongir
{
    partial class Login
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rdbStu = new System.Windows.Forms.RadioButton();
            this.rdbMaster = new System.Windows.Forms.RadioButton();
            this.grbMaster = new System.Windows.Forms.GroupBox();
            this.txtMasterPass = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtMasterUser = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.grbStu = new System.Windows.Forms.GroupBox();
            this.txtStuID = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnEnter = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.grbMaster.SuspendLayout();
            this.grbStu.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rdbStu);
            this.groupBox1.Controls.Add(this.rdbMaster);
            this.groupBox1.Location = new System.Drawing.Point(3, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(380, 56);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "کاربر";
            // 
            // rdbStu
            // 
            this.rdbStu.AutoSize = true;
            this.rdbStu.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdbStu.Location = new System.Drawing.Point(67, 18);
            this.rdbStu.Name = "rdbStu";
            this.rdbStu.Size = new System.Drawing.Size(75, 24);
            this.rdbStu.TabIndex = 2;
            this.rdbStu.Text = "دانشجو";
            this.rdbStu.UseVisualStyleBackColor = true;
            this.rdbStu.CheckedChanged += new System.EventHandler(this.rdbStu_CheckedChanged);
            // 
            // rdbMaster
            // 
            this.rdbMaster.AutoSize = true;
            this.rdbMaster.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rdbMaster.Location = new System.Drawing.Point(294, 18);
            this.rdbMaster.Name = "rdbMaster";
            this.rdbMaster.Size = new System.Drawing.Size(62, 24);
            this.rdbMaster.TabIndex = 1;
            this.rdbMaster.Text = "استاد";
            this.rdbMaster.UseVisualStyleBackColor = true;
            this.rdbMaster.CheckedChanged += new System.EventHandler(this.rdbMaster_CheckedChanged);
            // 
            // grbMaster
            // 
            this.grbMaster.Controls.Add(this.txtMasterPass);
            this.grbMaster.Controls.Add(this.label2);
            this.grbMaster.Controls.Add(this.txtMasterUser);
            this.grbMaster.Controls.Add(this.label1);
            this.grbMaster.Enabled = false;
            this.grbMaster.Location = new System.Drawing.Point(3, 65);
            this.grbMaster.Name = "grbMaster";
            this.grbMaster.Size = new System.Drawing.Size(380, 117);
            this.grbMaster.TabIndex = 2;
            this.grbMaster.TabStop = false;
            this.grbMaster.Text = "استاد";
            // 
            // txtMasterPass
            // 
            this.txtMasterPass.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtMasterPass.Location = new System.Drawing.Point(67, 64);
            this.txtMasterPass.Name = "txtMasterPass";
            this.txtMasterPass.Size = new System.Drawing.Size(179, 27);
            this.txtMasterPass.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(275, 67);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(85, 20);
            this.label2.TabIndex = 4;
            this.label2.Text = "رمز عبور :";
            // 
            // txtMasterUser
            // 
            this.txtMasterUser.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtMasterUser.Location = new System.Drawing.Point(67, 21);
            this.txtMasterUser.Name = "txtMasterUser";
            this.txtMasterUser.Size = new System.Drawing.Size(179, 27);
            this.txtMasterUser.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(268, 24);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(92, 20);
            this.label1.TabIndex = 2;
            this.label1.Text = "نام کاربری :";
            // 
            // grbStu
            // 
            this.grbStu.Controls.Add(this.txtStuID);
            this.grbStu.Controls.Add(this.label4);
            this.grbStu.Enabled = false;
            this.grbStu.Location = new System.Drawing.Point(3, 188);
            this.grbStu.Name = "grbStu";
            this.grbStu.Size = new System.Drawing.Size(380, 63);
            this.grbStu.TabIndex = 3;
            this.grbStu.TabStop = false;
            this.grbStu.Text = "دانشجو";
            // 
            // txtStuID
            // 
            this.txtStuID.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtStuID.Location = new System.Drawing.Point(67, 21);
            this.txtStuID.Name = "txtStuID";
            this.txtStuID.Size = new System.Drawing.Size(179, 27);
            this.txtStuID.TabIndex = 1;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(248, 24);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(126, 20);
            this.label4.TabIndex = 2;
            this.label4.Text = "شماره دانشجویی :";
            // 
            // btnCancel
            // 
            this.btnCancel.AutoSize = true;
            this.btnCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnCancel.Location = new System.Drawing.Point(193, 257);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(81, 30);
            this.btnCancel.TabIndex = 5;
            this.btnCancel.Text = "انصراف";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnEnter
            // 
            this.btnEnter.AutoSize = true;
            this.btnEnter.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEnter.Location = new System.Drawing.Point(290, 257);
            this.btnEnter.Name = "btnEnter";
            this.btnEnter.Size = new System.Drawing.Size(81, 30);
            this.btnEnter.TabIndex = 4;
            this.btnEnter.Text = "ورود";
            this.btnEnter.UseVisualStyleBackColor = true;
            this.btnEnter.Click += new System.EventHandler(this.btnEnter_Click);
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(387, 295);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnEnter);
            this.Controls.Add(this.grbStu);
            this.Controls.Add(this.grbMaster);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Login";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Text = "صفحه ی ورود";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Login_FormClosed);
            this.Load += new System.EventHandler(this.Login_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.grbMaster.ResumeLayout(false);
            this.grbMaster.PerformLayout();
            this.grbStu.ResumeLayout(false);
            this.grbStu.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton rdbStu;
        private System.Windows.Forms.RadioButton rdbMaster;
        private System.Windows.Forms.GroupBox grbMaster;
        private System.Windows.Forms.TextBox txtMasterPass;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtMasterUser;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox grbStu;
        private System.Windows.Forms.TextBox txtStuID;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnEnter;
    }
}