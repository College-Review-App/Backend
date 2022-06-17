import { useEffect, useState } from 'react';

// Material UI
import { Modal } from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';

// CSS Import
import './FullProfileModal.css';
import applicantProfile from '../../interfaces/applicantProfile';

// This component represents a a full profile modal that shows the complete
// statistics, background, extracirriculars, and advice of an anonymous applicant.

const FullProfileModal = ({
  refresh,
  open,
  profile,
}: {
  refresh: boolean;
  open: boolean;
  profile: applicantProfile;
}) => {
  const GPA = profile.getGPA.toFixed(2);
  const SAT = profile.getSAT < 0 ? 'N/A' : profile.getSAT;
  const ACT = profile.getACT < 0 ? 'N/A' : profile.getACT;
  const state = profile.getState === '' ? 'N/A' : profile.getState;
  const gender =
    profile.getGender === 0
      ? 'Male'
      : profile.getGender === 1
      ? 'Female'
      : 'Other';
  const firstGen = profile.getFirstGen ? 'Yes' : 'No';
  const familyIncome =
    profile.getFamilyIncome === 1000000
      ? '~250k+'
      : '~' + profile.getFamilyIncome / 1000 + 'k';
  const legacyStudent = profile.getLegacyStudent ? 'Yes' : 'No';
  const extracurricularArray = profile.getExtracurriculars.split('|+=+|');
  const profileDate = new Date(profile.getProfileDate);
  const dateStringDisplay = profileDate.toLocaleDateString();

  // State for closing and opening modal
  const [modalOpen, setModalOpen] = useState<boolean>(false);

  useEffect(() => {
    setModalOpen(open);
  }, [refresh]);

  // Handles closing the modal
  const handleClose = () => {
    setModalOpen(false);
  };

  return (
    <Modal open={modalOpen} onClose={handleClose}>
      <div className="fullProfileModalContainer">
        <div className="fullProfileHeaderModalContainer">
          {profile.getOutcome ? (
            <p className="fullProfileModalAcceptedHeader">
              Accepted : Class of {profile.getClassOf}
            </p>
          ) : (
            <p className="fullProfileModalRejectedHeader">
              Rejected : Class of {profile.getClassOf}
            </p>
          )}
          <CloseIcon
            style={{ cursor: 'pointer' }}
            onClick={() => handleClose()}
            fontSize="medium"
          />
        </div>
        <p>Intended Major: {profile.getIntendedMajor}</p>
        <div className="fullProfileBodyContainer">
          <div className="fullProfileLeftColumn">
            <div className="fullProfileStats">
              <h4>GPA and Test Scores</h4>
              <p>GPA: {GPA}</p>
              <p>SAT: {SAT}</p>
              <p>ACT: {ACT}</p>
            </div>
            <div className="fullProfileBackgroundInfo">
              <h4>Background</h4>
              <p>State: {state}</p>
              <p>Country: {profile.getCountry}</p>
              <p>Ethnicity: {profile.getEthnicity}</p>
              <p>Gender: {gender}</p>
              <p>First Gen: {firstGen}</p>
              <p>Family Income: {familyIncome} </p>
              <p>Legacy: {legacyStudent}</p>
            </div>
          </div>

          <div className="fullProfileRightColumn">
            <div className="fullProfileExtraCirriculars">
              <h4>Extracurriculars</h4>
              {extracurricularArray.map((ec: string, index: number) => (
                <p key={index}>{ec}</p>
              ))}
            </div>
            <div className="fullProfileAdvice">
              <h4>Advice</h4>
              <p>{profile.getAdvice}</p>
            </div>
          </div>
        </div>
        <div className="fullProfileDateAddedText">
          Date Added: {dateStringDisplay}
        </div>
      </div>
    </Modal>
  );
};

export default FullProfileModal;
